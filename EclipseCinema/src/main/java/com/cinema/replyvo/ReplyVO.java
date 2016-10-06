package com.cinema.replyvo;

public class ReplyVO {

	private int r_num = 0; //댓글번호
	private int m_num = 0; //게시판 글번호
	private String r_name =""; //댓글 작성자 아이디
	private String r_content =""; //댓글 내용
	private String r_date =""; //댓글 작성일
	private String r_grade =""; //댓글 평점
	
	
	public int getR_num() {
		return r_num;
	}
	public void setR_num(int r_num) {
		this.r_num = r_num;
	}
	public int getM_num() {
		return m_num;
	}
	public void setM_num(int m_num) {
		this.m_num = m_num;
	}
	public String getR_name() {
		return r_name;
	}
	public void setR_name(String r_name) {
		this.r_name = r_name;
	}
	public String getR_content() {
		return r_content;
	}
	public void setR_content(String r_content) {
		this.r_content = r_content;
	}
	public String getR_date() {
		return r_date;
	}
	public void setR_date(String r_date) {
		this.r_date = r_date;
	}
	public String getR_grade() {
		return r_grade;
	}
	public void setR_grade(String r_grade) {
		this.r_grade = r_grade;
	}
	
}
