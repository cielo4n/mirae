package com.nmom.soap.data.model.order;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VOrderManagerVo {

	private Date order_date;
	private int order_no;
	private String mem_name;
	private String product_name;
	private int buy_num;
	private int charge;
	private String delivery_msg;
	private int tracking_num;
	private String process_nm;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public VOrderManagerVo(){}

	public VOrderManagerVo(Date order_date, int order_no, String mem_name, String product_name, int buy_num, int charge,
			String delivery_msg, int tracking_num, String process_nm) {
		this.order_date = order_date;
		this.order_no = order_no;
		this.mem_name = mem_name;
		this.product_name = product_name;
		this.buy_num = buy_num;
		this.charge = charge;
		this.delivery_msg = delivery_msg;
		this.tracking_num = tracking_num;
		this.process_nm = process_nm;
	}

	@Override
	public String toString() {
		return "VOrderManagerVo [order_date=" + order_date + ", order_no=" + order_no + ", mem_name=" + mem_name
				+ ", product_name=" + product_name + ", buy_num=" + buy_num + ", charge=" + charge + ", delivery_msg="
				+ delivery_msg + ", tracking_num=" + tracking_num + ", process_nm=" + process_nm + "]";
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
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

	public String getDelivery_msg() {
		return delivery_msg;
	}

	public void setDelivery_msg(String delivery_msg) {
		this.delivery_msg = delivery_msg;
	}

	public int getTracking_num() {
		return tracking_num;
	}

	public void setTracking_num(int tracking_num) {
		this.tracking_num = tracking_num;
	}

	public String getProcess_nm() {
		return process_nm;
	}

	public void setProcess_nm(String process_nm) {
		this.process_nm = process_nm;
	}
	
}
