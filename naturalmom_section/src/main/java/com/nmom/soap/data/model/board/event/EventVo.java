package com.nmom.soap.data.model.board.event;

import java.util.Date;


public class EventVo {
	
	int event_no;
	String evt_title;
	Date evt_write_day;
	int evt_hits;
	String evt_content;
	int evt_del_check;
	int board_id;
	String mem_id;
	int count_re;
	int evt_rnum;
	
	
	// Constructor
	public EventVo() {	}

	// 모두
	public EventVo(int event_no, String evt_title, Date evt_write_day, int evt_hits, String evt_content,
			int evt_del_check, int board_id, String mem_id, int count_re) {
		super();
		this.event_no = event_no;
		this.evt_title = evt_title;
		this.evt_write_day = evt_write_day;
		this.evt_hits = evt_hits;
		this.evt_content = evt_content;
		this.evt_del_check = evt_del_check;
		this.board_id = board_id;
		this.mem_id = mem_id;
	}
	
	// 삭제여부 0 // 게시판번호 2
	public EventVo(int event_no, String evt_title, Date evt_write_day, int evt_hits, String evt_content,
			 String mem_id, int count_re) {
		super();
		this.event_no = event_no;
		this.evt_title = evt_title;
		this.evt_write_day = evt_write_day;
		this.evt_hits = evt_hits;
		this.evt_content = evt_content;
		this.evt_del_check = 0;
		this.board_id = 2;
		this.mem_id = mem_id;
	}

	
	// getter and setter
	public int getEvent_no() {
		return event_no;
	}

	public String getEvt_title() {
		return evt_title;
	}

	public Date getEvt_write_day() {
		return evt_write_day;
	}

	public int getEvt_hits() {
		return evt_hits;
	}

	public String getEvt_content() {
		return evt_content;
	}

	public int getEvt_del_check() {
		return evt_del_check;
	}

	public int getBoard_id() {
		return board_id;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setEvent_no(int event_no) {
		this.event_no = event_no;
	}

	public void setEvt_title(String evt_title) {
		this.evt_title = evt_title;
	}

	public void setEvt_write_day(Date evt_write_day) {
		this.evt_write_day = evt_write_day;
	}

	public void setEvt_hits(int evt_hits) {
		this.evt_hits = evt_hits;
	}

	public void setEvt_content(String evt_content) {
		this.evt_content = evt_content;
	}

	public void setEvt_del_check(int evt_del_check) {
		this.evt_del_check = evt_del_check;
	}

	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getCount_re() {
		return count_re;
	}

	public void setCount_re(int count_re) {
		this.count_re = count_re;
	}
	
	public int getEvt_rnum() {
		return evt_rnum;
	}
	
	public void setEvt_rnum(int evt_rnum) {
		this.evt_rnum = evt_rnum;
	}
	
	// 글쓰기 메소드
	public EventVo writeform(String title, String content, String id){
		this.evt_title=title;
		this.evt_content=content;
		this.mem_id=id;
		return this;
	}
	public EventVo editform(int event_no, String title, String content){
		this.event_no = event_no;
		this.evt_title=title;
		this.evt_content=content;
		return this;
	}

}
