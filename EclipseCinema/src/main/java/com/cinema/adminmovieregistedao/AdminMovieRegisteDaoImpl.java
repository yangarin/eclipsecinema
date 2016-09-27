package com.cinema.adminmovieregistedao;

import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.cinema.adminmovieregistevo.AdminMovieRegisteVO;

@Repository
public class AdminMovieRegisteDaoImpl implements AdminMovieRegisteDao {
	@Inject
	private SqlSession sqlSession;

	private static final String NAMESPACE = "com.cinema.adminmovieregistedao.AdminMovieMapper";

	// 등록된 영화 목록 구현
	@Override
	public List<AdminMovieRegisteVO> adminMovieList(AdminMovieRegisteVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".adminMovieList", avo);
	}

	// 영화등록 구현
	@Override
	public int adminMovieInsert(AdminMovieRegisteVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + ".adminMovieInsert", avo);
	}
//
//	// 영화정보 구현
//	@Override
//	public AdminMovieRegisteVO adminMovieDetail(AdminMovieRegisteVO avo) {
//		// TODO Auto-generated method stub
//		return sqlSession.selectOne(NAMESPACE + ".adminMovieDetail", avo);
//	}
//
//	// 영화 수정 구현
//	@Override
//	public int adminMovieUpdate(AdminMovieRegisteVO avo) {
//		// TODO Auto-generated method stub
//		return sqlSession.update(NAMESPACE + ".adminMovieUpdate", avo);
//	}
//
//	// 영화삭제구현
//	@Override
//	public int adminMovieDelete(int m_num) {
//		// TODO Auto-generated method stub
//		return sqlSession.delete(NAMESPACE + ".adminMovieDelete", m_num);
//	}

}
