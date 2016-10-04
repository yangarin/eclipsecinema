package com.cinema.replydao;

import java.util.List;
import com.cinema.replyvo.ReplyVO;

public interface ReplyDao {

	public List<ReplyVO> replyList(Integer m_num);
	public int replyInsert(ReplyVO rvo);
	/*public int pwdConfirm(ReplyVO rvo);*/
	public int replyUpdate(ReplyVO rvo);
	public int replyDelete(int r_num);

}
