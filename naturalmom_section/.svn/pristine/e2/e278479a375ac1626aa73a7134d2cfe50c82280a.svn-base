package com.nmom.soap.data.model.board.notice;

import java.util.Date;

public class NoticeVo {
	private int notice_no;
	private String ntc_title;
	private Date ntc_write_day;
	private int ntc_hits;
	private String ntc_content;
	private int ntc_del_check;
	private String ntc_attached_file1;
	private String ntc_attached_file2;
	private int board_id;
	private String mem_id;
	
	public NoticeVo(){}

	//게시글 수정 시 생성자
	public NoticeVo(int notice_no, String ntc_title, String ntc_content, String ntc_attached_file1, String ntc_attached_file2,
			String mem_id) {
		this.notice_no = notice_no;
		this.ntc_write_day = null;
		this.ntc_hits = 0; // 기본 조회수 0
		this.ntc_title = ntc_title;
		this.ntc_content = ntc_content;
		this.ntc_del_check = 0; // 0이면 삭제 안함
		this.ntc_attached_file1 = ntc_attached_file1;
		this.ntc_attached_file2 = ntc_attached_file2;
		this.board_id = 1;
		this.mem_id = mem_id;
	}
	
	public NoticeVo(int notice_no, String ntc_title, String ntc_content, String ntc_attached_file1, String ntc_attached_file2) {
		this.notice_no = notice_no;
		this.ntc_write_day = null;
		this.ntc_hits = 0; // 기본 조회수 0
		this.ntc_title = ntc_title;
		this.ntc_content = ntc_content;
		this.ntc_del_check = 0; // 0이면 삭제 안함
		this.ntc_attached_file1 = ntc_attached_file1;
		this.ntc_attached_file2 = ntc_attached_file2;
		this.board_id = 1;
		this.mem_id = null;
	}
	
	//게시글 생성 시 생성자
	public NoticeVo(String ntc_title, String ntc_content, String ntc_attached_file1, String ntc_attached_file2,
			String mem_id) {
		this.notice_no = 0;
		this.ntc_write_day = null;
		this.ntc_hits = 0; // 기본 조회수 0
		this.ntc_title = ntc_title;
		this.ntc_content = ntc_content;
		this.ntc_del_check = 0; // 0이면 삭제 안함
		this.ntc_attached_file1 = ntc_attached_file1;
		this.ntc_attached_file2 = ntc_attached_file2;
		this.board_id = 1;
		this.mem_id = mem_id;
	}


	//게시글 불러올때 생성자
	public NoticeVo(int notice_no, String ntc_title, Date ntc_write_day, int ntc_hits, String ntc_content,
			int ntc_del_check, String ntc_attached_file1, String ntc_attached_file2, String mem_id) {
		super();
		this.notice_no = notice_no;
		this.ntc_title = ntc_title;
		this.ntc_write_day = ntc_write_day;
		this.ntc_hits = ntc_hits;
		this.ntc_content = ntc_content;
		this.ntc_del_check = ntc_del_check;
		this.ntc_attached_file1 = ntc_attached_file1;
		this.ntc_attached_file2 = ntc_attached_file2;
		this.board_id = 1;
		this.mem_id = mem_id;
	}

	@Override
	public String toString() {
		return "NoticeVo [notice_no=" + notice_no + ", ntc_title=" + ntc_title + ", ntc_write_day=" + ntc_write_day
				+ ", ntc_hits=" + ntc_hits + ", ntc_content=" + ntc_content + ", ntc_del_check=" + ntc_del_check
				+ ", ntc_attached_file1=" + ntc_attached_file1 + ", ntc_attached_file2=" + ntc_attached_file2
				+ ", board_id=" + board_id + ", mem_id=" + mem_id + "]";
	}


	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getNtc_title() {
		return ntc_title;
	}

	public void setNtc_title(String ntc_title) {
		this.ntc_title = ntc_title;
	}

	public Date getNtc_write_day() {
		return ntc_write_day;
	}

	public void setNtc_write_day(Date ntc_write_day) {
		this.ntc_write_day = ntc_write_day;
	}

	public int getNtc_hits() {
		return ntc_hits;
	}

	public void setNtc_hits(int ntc_hits) {
		this.ntc_hits = ntc_hits;
	}

	public String getNtc_content() {		
		return ntc_content.replaceAll("null;", " ");
	}

	public void setNtc_content(String ntc_content) {
		this.ntc_content = ntc_content;
	}

	public int getNtc_del_check() {
		return ntc_del_check;
	}

	public void setNtc_del_check(int ntc_del_check) {
		this.ntc_del_check = ntc_del_check;
	}

	public String getNtc_attached_file1() {
		return ntc_attached_file1;
	}

	public void setNtc_attached_file1(String ntc_attached_file1) {
		this.ntc_attached_file1 = ntc_attached_file1;
	}

	public String getNtc_attached_file2() {
		return ntc_attached_file2;
	}

	public void setNtc_attached_file2(String ntc_attached_file2) {
		this.ntc_attached_file2 = ntc_attached_file2;
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
	
	
	
}
