package com.cinema.replydao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cinema.replyvo.ReplyVO;

@Repository
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	private SqlSession session;
	
	//글목록 구현
	@Override
	public List<ReplyVO> replyList(Integer m_num) {
		// TODO Auto-generated method stub
		return session.selectList("replyList", m_num);
	}

	//글입력 구현
	@Override
	public int replyInsert(ReplyVO rvo) {
		// TODO Auto-generated method stub
		return session.insert("replyInsert", rvo);
	}

	//글수정 구현
	@Override
	public int replyUpdate(ReplyVO rvo) {
		// TODO Auto-generated method stub
		return session.update("replyUpdate", rvo);
	}

	//글삭제 구현
	@Override
	public int replyDelete(int r_num) {
		// TODO Auto-generated method stub
		return session.delete("replyDelete", r_num);

	}

}
