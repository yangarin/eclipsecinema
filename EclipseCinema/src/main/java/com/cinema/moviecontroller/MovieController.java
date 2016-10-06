package com.cinema.moviecontroller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cinema.moviecommon.Paging;
import com.cinema.moviecommon.Util;
import com.cinema.moviefileupload.FileUploadUtil;
import com.cinema.movieservice.MovieService;
import com.cinema.movievo.MovieVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(value = "/movie")
public class MovieController {
	Logger logger = Logger.getLogger(MovieController.class);

	@Autowired
	private MovieService movieService;

	/**************************************************************
	 * 글목록 구현하기
	 **************************************************************/
	@RequestMapping(value = "/movieList", method = RequestMethod.GET)
	public String movieList(@ModelAttribute MovieVO mvo, Model model) {
		logger.info("movieList 호출 성공");

		// 정렬에 대한 기본값 설정
		if (mvo.getOrder_by() == null)
			mvo.setOrder_by("m_num");
		if (mvo.getOrder_sc() == null)
			mvo.setOrder_sc("DESC");

		// 정렬에 대한 데이터 확인
		logger.info("order_by = " + mvo.getOrder_by());
		logger.info("order_sc = " + mvo.getOrder_sc());

		// 검색에 대한 데이터 확인
		logger.info("search = " + mvo.getSearch());
		logger.info("keyword = " + mvo.getKeyword());

		// 페이지 셋팅
		Paging.setPage(mvo);

		// 전체 레코드 수 구하기
		int total = movieService.movieListCnt(mvo);
		logger.info("total = " + total);

		// 글번호 재설정
		int count = total - (Util.nvl(mvo.getPage()) - 1) * Util.nvl(mvo.getPageSize());
		logger.info("count = " + count);

		List<MovieVO> movieList = movieService.movieList(mvo);

		model.addAttribute("movieList", movieList);
		model.addAttribute("count", count);
		model.addAttribute("data", mvo);
		model.addAttribute("total", total);

		return "movie/movieList";
	}

	/**************************************************************
	 * 글쓰기 폼 출력하기 참고 : UUID는 128비트의 수이다. 표준 형식에서 UUID는 32개의 십육진수로 표현되며 총 36개
	 * 문자(32개 문자와 4개의 하이픈)로 된 8-4-4-4-12라는 5개의 그룹을 하이픈으로 구분한다. 이를테면 다음과 같다.
	 * 50e8400-e29b-41d4-a716-446655440000
	 **************************************************************/
	@RequestMapping(value = "/writeForm")
	public String writeForm(HttpSession session) {
		logger.info("writeForm 호출 성공");
		// 요청이 들어오면
		session.setAttribute("CSRF_TOKEN", UUID.randomUUID().toString());
		logger.info("CSRF_TOKEN : " + UUID.randomUUID().toString());
		return "movie/writeForm";
	}

	/**************************************************************
	 * 글쓰기 구현하기 참고 : RedirectAttributes 객체는 리다이렉트 시점에 한번만 사용되는 데이터를 전송할 수 있는
	 * addFlashAttribute()라는 기능을 지원한다. addFlashAttribute() 메서드는 브라우저까지 전송되기는
	 * 하지만, URI상에는 보이지 않는 숨겨진 데이터의 형태로 전달된다.
	 **************************************************************/
	/*
	 * @RequestMapping(value = "/movieInsert", method = RequestMethod.POST)
	 * public String movieInsert(@ModelAttribute MovieVO mvo) {
	 * logger.info("movieInsert 호출 성공");
	 * 
	 * int result = 0; String url = "";
	 * 
	 * result = movieService.movieInsert(mvo); if (result == 1) { url =
	 * "/movie/movieList.do"; }
	 * 
	 * return "redirect:" + url; }
	 */

	@RequestMapping(value = "/movieInsert", method = RequestMethod.POST)
	public String movieInsert(@ModelAttribute MovieVO mvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("movieInsert 호출 성공");
		logger.info("fileName : " + mvo.getFile().getOriginalFilename());
		logger.info("m_title : " + mvo.getM_title());
		int result = 0;
		String url = "";

		String m_file = FileUploadUtil.fileUpload(mvo.getFile(), request);
		mvo.setM_file(m_file);

		result = movieService.movieInsert(mvo);
		if (result == 1) {
			url = "/movie/movieList.do";
		}
		return "redirect:" + url;
	}

	/**************************************************************
	 * 글 상세보기 구현
	 **************************************************************/
	@RequestMapping(value = "/movieDetail", method = RequestMethod.GET)
	public String movieDetail(@ModelAttribute MovieVO pvo, Model model) {
		logger.info("movieDetail 호출 성공");
		logger.info("m_num = " + pvo.getM_num());

		MovieVO detail = new MovieVO();
		detail = movieService.movieDetail(pvo);

		if (detail != null && (!detail.equals(""))) {
			detail.setM_summary(detail.getM_summary().toString().replaceAll("\n", "<br>"));
		}

		model.addAttribute("detail", detail);

		return "movie/movieDetail";

	}

	/**************************************************************
	 * 비밀번호 확인 (불필요)
	 * 
	 * @param m_num
	 * @param m_pwd
	 * @return int 참고 : @ResponseBody는 전달된 뷰를 통해서 출력하는 것이 아니라 HTTP Response
	 *         Body에 직접 출력하는 방식.
	 **************************************************************//*
																	 * @ResponseBody
																	 * 
																	 * @RequestMapping
																	 * (value =
																	 * "/pwdConfirm",
																	 * method =
																	 * RequestMethod
																	 * .POST)
																	 * public
																	 * String
																	 * pwdConfirm
																	 * (@
																	 * ModelAttribute
																	 * MovieVO
																	 * mvo) {
																	 * logger.
																	 * info("pwdConfirm 호출 성공"
																	 * );
																	 * 
																	 * // 아래
																	 * 변수에는 입력
																	 * 성공에 대한
																	 * 상태값 저장(1
																	 * or 0) int
																	 * result =
																	 * 0; result
																	 * =
																	 * movieService
																	 * .
																	 * pwdConfirm
																	 * (mvo);
																	 * logger.
																	 * info("result = "
																	 * +
																	 * result);
																	 * 
																	 * return
																	 * result +
																	 * ""; }
																	 */

	/**************************************************************
	 * 글수정 폼 출력하기
	 * 
	 * @param :
	 *            m_num
	 * @return : MovieVO
	 **************************************************************/
	@RequestMapping(value = "/updateForm", method = RequestMethod.POST)
	public String updateForm(@ModelAttribute MovieVO pvo, Model model) {
		logger.info("updateForm 호출 성공");

		logger.info("m_num = " + pvo.getM_num());

		MovieVO updateData = new MovieVO();
		updateData = movieService.movieDetail(pvo);

		model.addAttribute("updateData", updateData);
		return "movie/updateForm";
	}

	/**************************************************************
	 * 글수정 구현하기
	 **************************************************************/
	@RequestMapping(value = "/movieUpdate", method = RequestMethod.POST)
	public String movieUpdate(@ModelAttribute MovieVO mvo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		logger.info("movieUpdate 호출 성공");

		int result = 0;
		String url = "";
		String m_file = "";

		if (!mvo.getFile().isEmpty()) {
			logger.info("===========m_file = " + mvo.getM_file());
			FileUploadUtil.fileDelete(mvo.getM_file(), request);
			m_file = FileUploadUtil.fileUpload(mvo.getFile(), request);
			mvo.setM_file(m_file);
		} else {
			logger.info("첨부파일 없음");
			mvo.setM_file("");
		}
		logger.info("==========m_file = " + mvo.getM_file());
		result = movieService.movieUpdate(mvo);
		if (result == 1) {
			// url="/movie/movieList.do"; // 수정 후 목록으로 이동
			// 아래 url은 수정 후 상세 페이지로 이동
			url = "/movie/movieDetail.do?m_num=" + mvo.getM_num();
			/*
			 * ra.addFlashAttribute("m_num",mvo.getM_num());
			 * url="/movie/movieDetail.do";
			 */
		}
		return "redirect:" + url;
	}

	/**************************************************************
	 * 글삭제 구현하기
	 **************************************************************/
	@RequestMapping(value = "/movieDelete")
	public String movieDelete(@ModelAttribute MovieVO mvo, HttpServletRequest request) throws IOException {
		logger.info("movieDelete 호출 성공");

		// 아래 변수에는 입력 성공에 대한 상태값 담습니다.(1 or 0)
		int result = 0;
		String url = "";

		FileUploadUtil.fileDelete(mvo.getM_file(), request);
		result = movieService.movieDelete(mvo.getM_num());
		if (result == 1) {
			url = "/movie/movieList.do";
		}

		return "redirect:" + url;
	}

	@ResponseBody
	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public String movie(@ModelAttribute MovieVO mvo, Model model, ObjectMapper om) {
		logger.info("movieList 호출 성공");
		String listData = "";
		List<MovieVO> movieList = movieService.movieList(mvo);
		try {
			listData = om.writeValueAsString(movieList);
			// System.out.println(listData);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return listData;
	}
	
	
	
	
	
	// 영화관 안내 폼 불러오기
	@RequestMapping(value = "/infoForm", method = RequestMethod.GET)
	public String InfoForm() {

		logger.info("infoForm 호출 성공");
		return "movie/infoForm";
	}
	
}
