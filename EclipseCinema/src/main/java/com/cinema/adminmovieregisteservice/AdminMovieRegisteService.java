package com.cinema.adminmovieregisteservice;

import java.util.List;

import com.cinema.adminmovieregistevo.AdminMovieRegisteVO;

public interface AdminMovieRegisteService {
	public List<AdminMovieRegisteVO> adminMovieList(AdminMovieRegisteVO avo);

	public int adminMovieInsert(AdminMovieRegisteVO avo);

//	public AdminMovieRegisteVO adminMovieDetail(AdminMovieRegisteVO avo);
//
//	public int adminMovieUpdate(AdminMovieRegisteVO avo);
//
//	public int adminMovieDelete(int m_num);
}
