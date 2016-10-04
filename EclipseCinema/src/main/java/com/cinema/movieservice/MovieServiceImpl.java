package com.cinema.movieservice;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cinema.moviedao.MovieDao;
import com.cinema.movievo.MovieVO;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	Logger logger = Logger.getLogger(MovieServiceImpl.class);

	@Autowired
	private MovieDao movieDao;

	// 영화 목록 구현
	@Override
	public List<MovieVO> movieList(MovieVO pvo) {
		// TODO Auto-generated method stub
		List<MovieVO> myList = null;
		myList = movieDao.movieList(pvo);
		return myList;
	}

	// 전체 레코드 수 구현
	@Override
	public int movieListCnt(MovieVO pvo) {
		return movieDao.movieListCnt(pvo);
	}

	// 영화 입력 구현
	@Override
	public int movieInsert(MovieVO pvo) {
		// TODO Auto-generated method stub
		int result = 0;
		result = movieDao.movieInsert(pvo);
		return result;
	}

	// 영화 상세 구현
	@Override
	public MovieVO movieDetail(MovieVO pvo) {
		// TODO Auto-generated method stub
		MovieVO detail = null;
		detail = movieDao.movieDetail(pvo);
		return detail;
	}

	// 영화 수정 구현
	@Override
	public int movieUpdate(MovieVO pvo) {
		// TODO Auto-generated method stub
		int result = 0;
		result = movieDao.movieUpdate(pvo);
		return result;

	}

	// 영화 삭제 구현
	@Override
	public int movieDelete(int m_num) {
		// TODO Auto-generated method stub
		int result = 0;
		result = movieDao.movieDelete(m_num);
		return result;
	}

}
