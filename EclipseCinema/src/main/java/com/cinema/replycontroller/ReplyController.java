package com.cinema.replycontroller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cinema.replyservice.ReplyService;
import com.cinema.replyvo.ReplyVO;

/**************************************************************
* REST(Representational State Transfer)의 약어로 하나의 URI는 하나의
* 고유한 리소스를 대표하도록 설계된다는 개념이다. 최근에는 서버에 접근하는 기기의
* 종류가 다양해지면서 다양한 기기에서 공통으로 데이터를 처리할 수 있는 규칙을 만들려고
* 하는데 이러한 시도가 REST방식이다.
* REST방식은 특정 URL는 반드시 그에 상응하는 데이터 자체라는 것을 의미하는 방식이다.
* 예를 들어 'movie/125'은 게시물 중에서 125번이라는 고유한 의미를 가지도록 설계하고,
* 이에 대한 처리는 GET, POST 방식과 같이 추가적인 정보를 통해서 결정한다.
**************************************************************/

/**************************************************************
 * 참고 : @RestController (@Controller + @ResponesBody) 기존의 특정한 JSP와 같은 뷰를 만들어 내는
 * 것이 목적이 아닌 REST 방식의 데이터 처리를 위해서 사용하는(데이터 자체를 반환) 어노테이션이다.
 **************************************************************/
@RestController
@RequestMapping(value = "/replies")
public class ReplyController {
	Logger logger = Logger.getLogger(ReplyController.class);

	@Autowired
	private ReplyService replyService;

	/**************************************************************
	 * 댓글 글목록 구현하기
	 * 
	 * @return List<ReplyVO> 참고 : @PathVariable는 URI의 경로에서 원하는 데이터를 추출하는 용도로 사용.
	 *         ResponseEntity 타입은 개발자가 직접 결과 데이터와 HTTP의 상태 코드를 직접 제어할 수 있는
	 *         클래스이다. 404나 500 같은 상태코드를 전송하고 싶은 데이터와 함께 전송할 수 있기 때문에 좀더 세밀한 제어가
	 *         가능.
	 **************************************************************/
	@RequestMapping(value = "/all/{m_num}.do", method = RequestMethod.GET)
	public ResponseEntity<List<ReplyVO>> list(@PathVariable("m_num") Integer m_num) {
		ResponseEntity<List<ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(replyService.replyList(m_num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/**************************************************************
	 * 댓글 글쓰기 구현하기
	 * 
	 * @return String 참고 : @RequestBody
	 **************************************************************/
	@RequestMapping(value = "/replyInsert")
	public ResponseEntity<String> replyInsert(@RequestBody ReplyVO rvo) {
		logger.info("replyInsert 호출 성공");
		ResponseEntity<String> entity = null;
		int result;
		try {
			result = replyService.replyInsert(rvo);
			if (result == 1) {
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/**************************************************************
	 * 댓글 수정 구현하기
	 * 
	 * @return 참고 : REST 방식에서 UPDATE 작업은 PUT,PATCH방식을 이용해서 처리. 전체 데이터를 수정하는 경우에는
	 *         PUT을 이용하고, 일부의 데이터를 수정하는 경우에는 PATCH를 이용.
	 **************************************************************/
	@RequestMapping(value = "/{r_num}.do", method = { RequestMethod.PUT, RequestMethod.PATCH })
	public ResponseEntity<String> replyUpdate(@PathVariable("r_num") Integer r_num, @RequestBody ReplyVO rvo) {
		logger.info("replyUpdate 호출 성공");
		ResponseEntity<String> entity = null;
		try {
			rvo.setR_num(r_num);
			replyService.replyUpdate(rvo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	/**************************************************************
	 * 댓글 삭제 구현하기
	 * 
	 * @return 참고 : REST 방식에서 DELETE 작업은 DELETE방식을 이용해서 처리.
	 **************************************************************/
	@RequestMapping(value = "/{r_num}.do", method = RequestMethod.DELETE)
	public ResponseEntity<String> replyDelete(@PathVariable("r_num") Integer r_num) {
		logger.info("replyDelete 호출 성공");
		ResponseEntity<String> entity = null;
		try {
			replyService.replyDelete(r_num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}