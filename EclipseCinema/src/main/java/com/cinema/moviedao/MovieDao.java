package com.cinema.moviedao;

import java.util.List;
import com.cinema.movievo.MovieVO;

public interface MovieDao {

	public List<MovieVO> movieList(MovieVO pvo);
	
	public int movieListCnt(MovieVO pvo);
	
	public int movieInsert(MovieVO pvo);
	public MovieVO movieDetail(MovieVO pvo);
	/*public int pwdConfirm(MovieVO pvo);*/
	public int movieUpdate(MovieVO pvo);
	public int movieDelete(int m_num);
	
}
