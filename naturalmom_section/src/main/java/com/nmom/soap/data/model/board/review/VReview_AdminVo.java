package com.nmom.soap.data.model.board.review;

import java.util.Date;

public class VReview_AdminVo
{
	// 멤버 �?��
	int review_no;
	int product_no;
	String product_name;
	String rvw_title;
	String rvw_content;
	String mem_id;
	Date rvw_write_day;
	int rvw_satisfaction;
	int rvw_hits;
	int re_num;
	int rvw_rnum;
	
	// ?�성??
	public VReview_AdminVo() {}
	
	// 모두 ?�력: 게시???�용 조회 ??
	public VReview_AdminVo(int review_no, int product_no, String product_name, String rvw_title, String rvw_content,
			String mem_id, Date rvw_write_day, int rvw_satisfaction, int rvw_hits, int re_num, int rvw_rnum) 
	{
		this.review_no = review_no;
		this.product_no = product_no;
		this.product_name = product_name;
		this.rvw_title = rvw_title;
		this.rvw_content = rvw_content;
		this.mem_id = mem_id;
		this.rvw_write_day = rvw_write_day;
		this.rvw_satisfaction = rvw_satisfaction;
		this.rvw_hits = rvw_hits;
		this.re_num = re_num;
		this.rvw_rnum = rvw_rnum;
	}
	
//	// 조회?? ?�용 ?�음 (0, null �??�일): 게시??목록 조회, �?�� 결과
//	public VReview_AdminVo(int review_no, int product_no, String product_name, String rvw_title,
//			String mem_id, Date rvw_write_day, int rvw_satisfaction, int re_num) 
//	{
//		this.review_no = review_no;
//		this.product_no = product_no;
//		this.product_name = product_name;
//		this.rvw_title = rvw_title;
//		this.rvw_content = null;
//		this.mem_id = mem_id;
//		this.rvw_write_day = rvw_write_day;
//		this.rvw_satisfaction = rvw_satisfaction;
//		this.rvw_hits = 0;
//		this.re_num = re_num;
//	}

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

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getRvw_title() {
		return rvw_title;
	}

	public void setRvw_title(String rvw_title) {
		this.rvw_title = rvw_title;
	}

	public String getRvw_content() {
		return rvw_content;
	}

	public void setRvw_content(String rvw_content) {
		this.rvw_content = rvw_content;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public Date getRvw_write_day() {
		return rvw_write_day;
	}

	public void setRvw_write_day(Date rvw_write_day) {
		this.rvw_write_day = rvw_write_day;
	}

	public int getRvw_satisfaction() {
		return rvw_satisfaction;
	}

	public void setRvw_satisfaction(int rvw_satisfaction) {
		this.rvw_satisfaction = rvw_satisfaction;
	}

	public int getRvw_hits() {
		return rvw_hits;
	}

	public void setRvw_hits(int rvw_hits) {
		this.rvw_hits = rvw_hits;
	}

	public int getRe_num() {
		return re_num;
	}

	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	
	public int getRvw_rnum() {
		return rvw_rnum;
	}

	public void setRvw_rnum(int rvw_rnum) {
		this.rvw_rnum = rvw_rnum;
	}

	@Override
	public String toString() {
		return "VReview_AdminVo [review_no=" + review_no + ", product_no=" + product_no + ", product_name="
				+ product_name + ", rvw_title=" + rvw_title + ", rvw_content=" + rvw_content + ", mem_id=" + mem_id
				+ ", rvw_write_day=" + rvw_write_day + ", rvw_satisfaction=" + rvw_satisfaction + ", rvw_hits="
				+ rvw_hits + ", re_num=" + re_num + ", rvw_rnum=" + rvw_rnum + "]";
	}
}
