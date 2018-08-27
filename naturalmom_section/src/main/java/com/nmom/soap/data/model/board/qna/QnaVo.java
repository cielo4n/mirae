package com.nmom.soap.data.model.board.qna;

import java.util.Date;

public class QnaVo {
	private int qna_no;
	private String qna_title;
	private Date qna_write_day;
	private int qna_hits;
	private String qna_content;
	private int qna_del_check;
	private String qna_pw;
	private int qna_pos;
	private int qna_ref;
	private int board_id;
	private String mem_id;
	
	public QnaVo(){}

	//일반글작성
	public QnaVo(String qna_title, String qna_content, String qna_pw, String mem_id) {
		qna_no = 0;
		this.qna_title = qna_title;
		qna_write_day = new Date();
		this.qna_content = qna_content;
		qna_del_check = 0;
		this.qna_pw = qna_pw;
		qna_pos = 0;
		qna_ref = qna_no; //참조값이 자기번호와 같아야 일반글
		board_id = 4;
		this.mem_id = mem_id;
	}

	//답변글작성
	public QnaVo(String qna_title, String qna_content, String qna_pw, int qna_pos, int qna_ref, String mem_id) {
		qna_no = 0;
		this.qna_title = qna_title;
		qna_write_day = new Date();
		this.qna_content = qna_content;
		qna_del_check = 0;
		this.qna_pw = qna_pw;
		this.qna_pos = qna_pos;
		this.qna_ref = qna_ref;
		board_id = 4;
		this.mem_id = mem_id;
	}
	
	public QnaVo(int qna_no, String qna_title, Date qna_write_day, int qna_hits, String qna_content, int qna_del_check,
			String qna_pw, int qna_pos, int qna_ref, int board_id, String mem_id) {
		super();
		this.qna_no = qna_no;
		this.qna_title = qna_title;
		this.qna_write_day = qna_write_day;
		this.qna_hits = qna_hits;
		this.qna_content = qna_content;
		this.qna_del_check = qna_del_check;
		this.qna_pw = qna_pw;
		this.qna_pos = qna_pos;
		this.qna_ref = qna_ref;
		this.board_id = board_id;
		this.mem_id = mem_id;
	}
	
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public Date getQna_write_day() {
		return qna_write_day;
	}
	public void setQna_write_day(Date qna_write_day) {
		this.qna_write_day = qna_write_day;
	}
	public int getQna_hits() {
		return qna_hits;
	}
	public void setQna_hits(int qna_hits) {
		this.qna_hits = qna_hits;
	}
	public String getQna_content() {
		return qna_content;
	}
	public void setQna_content(String qna_content) {
		this.qna_content = qna_content;
	}
	public int getQna_del_check() {
		return qna_del_check;
	}
	public void setQna_del_check(int qna_del_check) {
		this.qna_del_check = qna_del_check;
	}
	public String getQna_pw() {
		return qna_pw;
	}
	public void setQna_pw(String qna_pw) {
		this.qna_pw = qna_pw;
	}
	public int getQna_pos() {
		return qna_pos;
	}
	public void setQna_pos(int qna_pos) {
		this.qna_pos = qna_pos;
	}
	public int getQna_ref() {
		return qna_ref;
	}
	public void setQna_ref(int qna_ref) {
		this.qna_ref = qna_ref;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	@Override
	public String toString() {
		return "QnaVO [qna_no=" + qna_no + ", qna_title=" + qna_title + ", qna_write_day=" + qna_write_day
				+ ", qna_hits=" + qna_hits + ", qna_content=" + qna_content + ", qna_del_check=" + qna_del_check
				+ ", qna_pw=" + qna_pw + ", qna_pos=" + qna_pos + ", qna_ref=" + qna_ref + ", board_id=" + board_id
				+ ", mem_id=" + mem_id + "]";
	}
}