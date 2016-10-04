package com.cinema.moviedao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cinema.movievo.MovieVO;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SqlSession session;

	// 글목록 구현
	@Override
	public List<MovieVO> movieList(MovieVO pvo) {
		return session.selectList("movieList", pvo);
	}

	// 전체 레코드 건수 구현
	@Override
	public int movieListCnt(MovieVO pvo) {
		return (Integer) session.selectOne("movieListCnt", pvo);
	}

	// 글상세 구현
	@Override
	public MovieVO movieDetail(MovieVO pvo) {
		return (MovieVO) session.selectOne("movieDetail", pvo);
	}

	// 글입력 구현
	@Override
	public int movieInsert(MovieVO pvo) {
		return session.insert("movieInsert", pvo);
	}

	// 비밀번호 확인 구현
	/*@Override
	public int pwdConfirm(MovieVO pvo) {
		return (Integer) session.selectOne("pwdConfirm", pvo);
	}*/

	// 글수정 구현
	@Override
	public int movieUpdate(MovieVO pvo) {
		return session.update("movieUpdate", pvo);
	}

	// 글삭제 구현
	@Override
	public int movieDelete(int m_num) {
		return session.delete("movieDelete", m_num);
	}

}
