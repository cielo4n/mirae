package com.nmom.soap.data.model.order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VOrderListVo {
	private int order_no;
	private Date order_date;
	private String represent_img;
	private String product_name;
	private int buy_num;
	private int charge;
	private String process_nm;
	private String mem_id;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public VOrderListVo(){}

	public VOrderListVo(int order_no, Date order_date, String represent_img, String product_name, int buy_num,
			int charge, String process_nm, String mem_id) {
		super();
		this.order_no = order_no;
		this.order_date = order_date;
		this.represent_img = represent_img;
		this.product_name = product_name;
		this.buy_num = buy_num;
		this.charge = charge;
		this.process_nm = process_nm;
		this.mem_id = mem_id;
	}

	@Override
	public String toString() {
		return "VOrderListVo [order_no=" + order_no + ", order_date=" + order_date + ", represent_img=" + represent_img
				+ ", product_name=" + product_name + ", buy_num=" + buy_num + ", charge=" + charge + ", process_nm="
				+ process_nm + ", mem_id=" + mem_id + "]";
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getRepresent_img() {
		return represent_img.split(",")[0];
	}

	public void setRepresent_img(String represent_img) {
		this.represent_img = represent_img;
	}

	public String getProduct_name() {
		String name[] = product_name.split(",");
		if(name.length > 1){
			return name[0]+" 외 "+ (name.length-1)+"종";
		}
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public String getProcess_nm() {
		return process_nm;
	}

	public void setProcess_nm(String process_nm) {
		this.process_nm = process_nm;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

}
