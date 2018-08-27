package com.nmom.soap.data.model.interest;

public class VInterestProductVo {
	
	private int product_no;
	private String product_name;
	private int selling_price;
	private int sale_state;
	private String represent_img;
	private int stock;
	private String mem_id;
	
	public VInterestProductVo(){}
	public VInterestProductVo(int product_no, String product_name, int selling_price, int sale_state, String represent_img,
			int stock, String mem_id) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.selling_price = selling_price;
		this.sale_state = sale_state;
		this.represent_img = represent_img;
		this.stock = stock;
		this.mem_id = mem_id;
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
	public int getSelling_price() {
		return selling_price;
	}
	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}
	public int getSale_state() {
		return sale_state;
	}
	public void setSale_state(int sale_state) {
		this.sale_state = sale_state;
	}
	public String getRepresent_img() {
		return represent_img;
	}
	public void setRepresent_img(String represent_img) {
		this.represent_img = represent_img;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "VInterestProductVo [product_no=" + product_no + ", product_name=" + product_name + ", selling_price="
				+ selling_price + ", sale_state=" + sale_state + ", represent_img=" + represent_img + ", stock=" + stock
				+ ", mem_id=" + mem_id + "]";
	}
}