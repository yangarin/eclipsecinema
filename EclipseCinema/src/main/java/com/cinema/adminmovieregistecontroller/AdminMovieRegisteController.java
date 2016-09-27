package com.cinema.adminmovieregistecontroller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cinema.adminmovieregisteservice.AdminMovieRegisteService;
import com.cinema.adminmovieregistevo.AdminMovieRegisteVO;

@Controller
@RequestMapping(value = "/adminMovie")

public class AdminMovieRegisteController {
	Logger logger = Logger.getLogger(AdminMovieRegisteController.class);

	@Autowired
	private AdminMovieRegisteService AdminMovieRegisteService;

	// 등록된 영화 목록 구현

	@RequestMapping(value = "/adminMovieList")
	public String adminMovieList(@ModelAttribute AdminMovieRegisteVO avo, Model model) {
		logger.info("AdminMovieList 호출성공");

		List<AdminMovieRegisteVO> adminMovieList = AdminMovieRegisteService.adminMovieList(avo);
		model.addAttribute("adminMovieList", adminMovieList);
		return "adminMovie/adminMovieList";
	}

	// 영화 등록 폼
	@RequestMapping(value = "/adminMovieWriteForm", method = RequestMethod.GET)
	public String adminMovieWriteForm() {

		logger.info("adminMovieWriteForm 호출 성공");
		return "adminMovie/adminMovieWriteForm";
	}

	// 영화 등록 기능
	@RequestMapping(value = "/adminMovieInsert", method = RequestMethod.POST)
	public String adminMovieInsert(@ModelAttribute AdminMovieRegisteVO avo) {
		logger.info("adminMovieInsert 호출 성공");
		int result = 0;
		String url = "";
		result = AdminMovieRegisteService.adminMovieInsert(avo);
		if (result == 1) {
			url = "/adminMovie/adminMovieList.do";
		}
		return "redirect:" + url;
	}
//
//	// 등록한 영화정보 보기
//	@RequestMapping(value = "/adminMovieDetail", method = RequestMethod.GET)
//	public String adminMovieDetail(@ModelAttribute AdminMovieRegisteVO avo, Model model) {
//
//		logger.info("adminMovieDetail 호출 성공");
//		logger.info("m_num = " + avo.getM_num());
//		AdminMovieRegisteVO adminMovieDetail = new AdminMovieRegisteVO();
//		adminMovieDetail = AdminMovieRegisteService.adminMovieDetail(avo);
//		if (adminMovieDetail != null && (!adminMovieDetail.equals(""))) {
//
//			adminMovieDetail.setM_summary(adminMovieDetail.getM_summary().toString().replaceAll("\n", "<br>"));
//		}
//		model.addAttribute("adminMovieDetail", adminMovieDetail);
//		return "adminMovie/adminMovieDetail";
//	}
//
//	// 영화 수정 폼
//
//	@RequestMapping(value = "/adminMovieUpdateForm", method = RequestMethod.POST)
//	public String adminMovieUpdateForm(@ModelAttribute AdminMovieRegisteVO avo, Model model) {
//		logger.info("adminMovieUpdateForm 호출 성공");
//
//		logger.info("m_num = " + avo.getM_num());
//		AdminMovieRegisteVO updateData = new AdminMovieRegisteVO();
//		updateData = AdminMovieRegisteService.adminMovieDetail(avo);
//		model.addAttribute("updateData", updateData);
//		return "adminMovie/adminMovieUpdateForm";
//
//	}
//
//	// 영화 수정 구현
//	@RequestMapping(value = "/adminMovieUpdate", method = RequestMethod.POST)
//	public String adminMovieUpdate(@ModelAttribute AdminMovieRegisteVO avo) {
//		logger.info("adminMovieUpdate 호출 성공");
//		int result = 0;
//		String url = "";
//		result = AdminMovieRegisteService.adminMovieUpdate(avo);
//		if (result == 1) {
//			url = "adminMovie/adminMovieList";
//		}
//		return "redirect:" + url;
//	}
//
//	// 영화 삭제 구현
//	@RequestMapping(value = "/adminMovieDelete")
//	public String adminMovieDelete(@ModelAttribute AdminMovieRegisteVO avo) {
//
//		logger.info("adminMovieDelete 호출 성공");
//		// 아래 변수에는 입력 성공에 대한 상태값 담습니다.(1 or 0)
//		int result = 0;
//		String url = "";
//		result = AdminMovieRegisteService.adminMovieDelete(avo.getM_num());
//		if (result == 1) {
//			url = "adminMovie/adminMovieList";
//		}
//		return "redirect:" + url;
//	}
}
