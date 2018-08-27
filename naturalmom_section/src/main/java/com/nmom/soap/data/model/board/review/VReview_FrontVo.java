package com.nmom.soap.data.model.board.review;

import java.util.Date;

public class VReview_FrontVo 
{
	// Î©§Î≤Ñ Î≥?àò
	int review_no;
	int product_no;
	String rvw_title;
	Date rvw_write_day;
	int rvw_hits;
	String rvw_content;
	int rvw_satisfaction;
	String mem_id;
	int re_num;
	
	// ?ùÏÑ±??
	public VReview_FrontVo() {}
	
	public VReview_FrontVo(int review_no, int product_no, String rvw_title, Date rvw_write_day, int rvw_hits,
			String rvw_content, int rvw_satisfaction, String mem_id, int re_num) 
	{
		this.review_no = review_no;
		this.product_no = product_no;
		this.rvw_title = rvw_title;
		this.rvw_write_day = rvw_write_day;
		this.rvw_hits = rvw_hits;
		this.rvw_content = rvw_content;
		this.rvw_satisfaction = rvw_satisfaction;
		this.mem_id = mem_id;
		this.re_num = re_num;
	}
	
	

	// getter and setter
	public int getReview_no() {
		return review_no;
	}

	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getRvw_title() {
		return rvw_title;
	}

	public void setRvw_title(String rvw_title) {
		this.rvw_title = rvw_title;
	}

	public Date getRvw_write_day() {
		return rvw_write_day;
	}

	public void setRvw_write_day(Date rvw_write_day) {
		this.rvw_write_day = rvw_write_day;
	}

	public int getRvw_hits() {
		return rvw_hits;
	}

	public void setRvw_hits(int rvw_hits) {
		this.rvw_hits = rvw_hits;
	}

	public String getRvw_content() {
		return rvw_content;
	}

	public void setRvw_content(String rvw_content) {
		this.rvw_content = rvw_content;
	}

	public int getRvw_satisfaction() {
		return rvw_satisfaction;
	}

	public void setRvw_satisfaction(int rvw_satisfaction) {
		this.rvw_satisfaction = rvw_satisfaction;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getRe_num() {
		return re_num;
	}

	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}

	@Override
	public String toString() {
		return "VReview_FrontVo [review_no=" + review_no + ", product_no=" + product_no + ", rvw_title=" + rvw_title
				+ ", rvw_write_day=" + rvw_write_day + ", rvw_hits=" + rvw_hits + ", rvw_content=" + rvw_content
				+ ", rvw_satisfaction=" + rvw_satisfaction + ", mem_id=" + mem_id + ", re_num=" + re_num + "]";
	}	
}
