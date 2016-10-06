package com.cinema.movievo;

import org.springframework.web.multipart.MultipartFile;
import com.cinema.moviecommon.PagingVO;

public class MovieVO extends PagingVO {

	private int m_num = 0; //영화 번호
	private String m_title = ""; // 영화 제목	
	private String m_director = ""; // 영화 감독
	private String m_star = ""; // 영화 주연
	private String m_support = ""; // 영화 조연
	private String m_runningtime = ""; // 상영시간
	private String m_releasedate = ""; // 개봉일
	private String m_summary = ""; // 줄거리
	private String m_grade = ""; // 상영등급
	private String m_country = ""; // 나라
	private String m_genre = ""; // 장르
	private String m_date = ""; // 등록일
	private String m_score = ""; //평점
	private String m_preview = ""; //예고편 동영상 URL
	
	//조건검색시 사용할 필드
	private String search = "";
	private String keyword = "";
	
	//열제목 클릭시 정렬을 위한 필드
	private String order_by;
	private String order_sc;
	
	// 포스터 사진 업로드를 위한 속성
	private MultipartFile file; // 첨부파일
	private String m_file = ""; // 실제서버에 저장한 파일명
		
		
	
	public String getM_preview() {
		return m_preview;
	}
	public void setM_preview(String m_preview) {
		this.m_preview = m_preview;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getM_title() {
		return m_title;
	}
	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
	public String getM_director() {
		return m_director;
	}
	public void setM_director(String m_director) {
		this.m_director = m_director;
	}
	public String getM_star() {
		return m_star;
	}
	public void setM_star(String m_star) {
		this.m_star = m_star;
	}
	public String getM_support() {
		return m_support;
	}
	public void setM_support(String m_support) {
		this.m_support = m_support;
	}
	public String getM_runningtime() {
		return m_runningtime;
	}
	public void setM_runningtime(String m_runningtime) {
		this.m_runningtime = m_runningtime;
	}
	public String getM_releasedate() {
		return m_releasedate;
	}
	public void setM_releasedate(String m_releasedate) {
		this.m_releasedate = m_releasedate;
	}
	public String getM_summary() {
		return m_summary;
	}
	public void setM_summary(String m_summary) {
		this.m_summary = m_summary;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	public String getM_country() {
		return m_country;
	}
	public void setM_country(String m_country) {
		this.m_country = m_country;
	}
	public String getM_genre() {
		return m_genre;
	}
	public void setM_genre(String m_genre) {
		this.m_genre = m_genre;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public String getM_score() {
		return m_score;
	}
	public void setM_score(String m_score) {
		this.m_score = m_score;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOrder_by() {
		return order_by;
	}
	public void setOrder_by(String order_by) {
		this.order_by = order_by;
	}
	public String getOrder_sc() {
		return order_sc;
	}
	public void setOrder_sc(String order_sc) {
		this.order_sc = order_sc;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getM_file() {
		return m_file;
	}
	public void setM_file(String m_file) {
		this.m_file = m_file;
	}		
		
}
