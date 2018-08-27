package com.nmom.soap.data.model.board.faq;

public class FaqVo {
	private int faq_no;
	private String faq_title;
	private String faq_content;
	private int faq_del_check;
	private int board_id;
	private String mem_id;
	private int faq_rnum;
	
	public FaqVo(){}
	
	public FaqVo(String faq_title, String faq_content, String mem_id) {
		faq_no = 0;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		faq_del_check = 0;
		board_id = 3;
		this.mem_id = mem_id;
	}

	public FaqVo(int faq_no, String faq_title, String faq_content, int faq_del_check, int board_id, String mem_id) {
		super();
		this.faq_no = faq_no;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_del_check = faq_del_check;
		this.board_id = board_id;
		this.mem_id = mem_id;
	}
	public int getFaq_no() {
		return faq_no;
	}
	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public int getFaq_del_check() {
		return faq_del_check;
	}
	public void setFaq_del_check(int faq_del_check) {
		this.faq_del_check = faq_del_check;
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
	public void setFaq_rnum(int faq_rnum){
		this.faq_rnum = faq_rnum;
	}
	public int getFaq_rnum(){
		return this.faq_rnum;
	}
	
	@Override
	public String toString() {
		return "FaqVo [faq_rnum ="+ faq_rnum + ", faq_no=" + faq_no + ", faq_title=" + faq_title + ", faq_content=" + faq_content
				+ ", faq_del_check=" + faq_del_check + ", board_id=" + board_id + ", mem_id=" + mem_id + "]";
	}
}