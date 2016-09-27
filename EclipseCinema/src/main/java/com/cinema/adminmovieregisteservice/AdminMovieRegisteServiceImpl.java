package com.cinema.adminmovieregisteservice;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinema.adminmovieregistedao.AdminMovieRegisteDao;
import com.cinema.adminmovieregistevo.AdminMovieRegisteVO;

@Service
@Transactional
public class AdminMovieRegisteServiceImpl implements AdminMovieRegisteService {
	Logger logger = Logger.getLogger(AdminMovieRegisteServiceImpl.class);

	@Autowired
	private AdminMovieRegisteDao AdminMovieRegisteDao;

	// 등록된 영화 구현
	@Override
	public List<AdminMovieRegisteVO> adminMovieList(AdminMovieRegisteVO avo) {
		// TODO Auto-generated method stub
		List<AdminMovieRegisteVO> myList = new ArrayList<AdminMovieRegisteVO>();
		myList = AdminMovieRegisteDao.adminMovieList(avo);
		return myList;

	}

	// 영화등록 구현
	@Override
	public int adminMovieInsert(AdminMovieRegisteVO avo) {
		// TODO Auto-generated method stub
		int result = 0;
		result = AdminMovieRegisteDao.adminMovieInsert(avo);
		return result;
	}

//	@Override
//	public AdminMovieRegisteVO adminMovieDetail(AdminMovieRegisteVO avo) {
//		// TODO Auto-generated method stub
//		AdminMovieRegisteVO detail = null;
//		detail = AdminMovieRegisteDao.adminMovieDetail(avo);
//		return detail;
//	}
//
//	@Override
//	public int adminMovieUpdate(AdminMovieRegisteVO avo) {
//		// TODO Auto-generated method stub
//		int result = 0;
//		result = AdminMovieRegisteDao.adminMovieUpdate(avo);
//		return result;
//	}
//
//	@Override
//	public int adminMovieDelete(int m_num) {
//		// TODO Auto-generated method stub
//		int result = 0;
//		result = AdminMovieRegisteDao.adminMovieDelete(m_num);
//		return result;
//	}

}
