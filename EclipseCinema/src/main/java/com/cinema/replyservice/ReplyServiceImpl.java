package com.cinema.replyservice;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cinema.replydao.ReplyDao;
import com.cinema.replyvo.ReplyVO;

@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

	Logger logger = Logger.getLogger(ReplyServiceImpl.class);
	
	@Autowired
	 private ReplyDao replyDao;

	//글목록 구현
	@Override
	public List<ReplyVO> replyList(Integer m_num) {
		// TODO Auto-generated method stub
		List<ReplyVO> myList = null;
		myList = replyDao.replyList(m_num);
		return myList;
	}

	//글입력 구현
	@Override
	public int replyInsert(ReplyVO rvo) {
		// TODO Auto-generated method stub
		int result = 0;
		result = replyDao.replyInsert(rvo);
		return result;
	}

	//글수정 구현
	@Override
	public int replyUpdate(ReplyVO rvo) {
		// TODO Auto-generated method stub
		int result = 0;
		result = replyDao.replyUpdate(rvo);
		return result;
	}

	//글삭제 구현
	@Override
	public int replyDelete(int r_num) {
		// TODO Auto-generated method stub
		int result = 0;
		result = replyDao.replyDelete(r_num);
		return result;

	}

}
