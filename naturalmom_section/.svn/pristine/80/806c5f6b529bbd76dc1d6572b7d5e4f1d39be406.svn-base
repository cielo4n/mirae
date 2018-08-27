package com.nmom.soap.data.model.board.event;

import java.util.Date;


public class Event_reVo {

	int event_re_no;
	String evt_re_content;
	Date evt_re_write_day;
	int evt_re_del_check;
	int evt_no;
	String mem_id;
	
	
	// Constructor
	public Event_reVo() {	}

	// insert All
	public Event_reVo(int event_re_no, String evt_re_content, Date evt_re_write_day, int evt_re_del_check, int evt_no,
			String mem_id) {
		super();
		this.event_re_no = event_re_no;
		this.evt_re_content = evt_re_content;
		this.evt_re_write_day = evt_re_write_day;
		this.evt_re_del_check = evt_re_del_check;
		this.evt_no = evt_no;
		this.mem_id = mem_id;
	}
	
	// except delete
	public Event_reVo(int event_re_no, String evt_re_content, Date evt_re_write_day, int evt_no,
			String mem_id) {
		super();
		this.event_re_no = event_re_no;
		this.evt_re_content = evt_re_content;
		this.evt_re_write_day = evt_re_write_day;
		this.evt_re_del_check = 0;
		this.evt_no = evt_no;
		this.mem_id = mem_id;
	}
	
	
	
	
	// getter and setter
	public int getEvent_re_no() {
		return event_re_no;
	}

	public String getEvt_re_content() {
		return evt_re_content;
	}

	public Date getEvt_re_write_day() {
		return evt_re_write_day;
	}

	public int getEvt_re_del_check() {
		return evt_re_del_check;
	}

	public int getEvt_no() {
		return evt_no;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setEvent_re_no(int event_re_no) {
		this.event_re_no = event_re_no;
	}

	public void setEvt_re_content(String evt_re_content) {
		this.evt_re_content = evt_re_content;
	}

	public void setEvt_re_write_day(Date evt_re_write_day) {
		this.evt_re_write_day = evt_re_write_day;
	}

	public void setEvt_re_del_check(int evt_re_del_check) {
		this.evt_re_del_check = evt_re_del_check;
	}

	public void setEvt_no(int evt_no) {
		this.evt_no = evt_no;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public Event_reVo writeform(int parant_no, String content, String id){
		this.evt_no = parant_no;
		this.evt_re_content = content;
		this.mem_id = id;
		return this;
	}
	
}
