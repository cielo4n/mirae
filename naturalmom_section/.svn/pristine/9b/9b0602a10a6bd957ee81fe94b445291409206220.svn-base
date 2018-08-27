package com.nmom.soap.data.model.board.notice;

import java.util.Date;

public class NoticeReVo {
	private int notice_re_no;
	private String ntc_re_content;
	private Date ntc_re_write_day;
	private int ntc_re_del_check;
	private int notice_no;
	private String mem_id;
	
	public NoticeReVo() {}

	//댓글 추가
	public NoticeReVo(String ntc_re_content, int notice_no, String mem_id) {
		this.notice_re_no = 0;
		this.ntc_re_content = ntc_re_content;
		this.ntc_re_write_day = null;
		this.ntc_re_del_check = 0;
		this.notice_no = notice_no;
		this.mem_id = mem_id;
	}
	
	//댓글 불러올때
	public NoticeReVo(int notice_re_no, String ntc_re_content, Date ntc_re_write_day, int ntc_re_del_check,
			int notice_no, String mem_id) {
		this.notice_re_no = notice_re_no;
		this.ntc_re_content = ntc_re_content;
		this.ntc_re_write_day = ntc_re_write_day;
		this.ntc_re_del_check = ntc_re_del_check;
		this.notice_no = notice_no;
		this.mem_id = mem_id;
	}
	
	@Override
	public String toString() {
		return "NoticeReVo [notice_re_no=" + notice_re_no + ", ntc_re_content=" + ntc_re_content + ", ntc_re_write_day="
				+ ntc_re_write_day + ", ntc_re_del_check=" + ntc_re_del_check + ", notice_no=" + notice_no + ", mem_id="
				+ mem_id + "]";
	}

	public int getNotice_re_no() {
		return notice_re_no;
	}

	public void setNotice_re_no(int notice_re_no) {
		this.notice_re_no = notice_re_no;
	}

	public String getNtc_re_content() {
		return ntc_re_content.replaceAll("null;", " ");
	}

	public void setNtc_re_content(String ntc_re_content) {
		this.ntc_re_content = ntc_re_content;
	}

	public Date getNtc_re_write_day() {
		return ntc_re_write_day;
	}

	public void setNtc_re_write_day(Date ntc_re_write_day) {
		this.ntc_re_write_day = ntc_re_write_day;
	}

	public int getNtc_re_del_check() {
		return ntc_re_del_check;
	}

	public void setNtc_re_del_check(int ntc_re_del_check) {
		this.ntc_re_del_check = ntc_re_del_check;
	}

	public int getNotice_no() {
		return notice_no;
	}

	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}
