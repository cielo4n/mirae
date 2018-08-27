package com.nmom.soap.data.model.product;

public class VProduct_DeletedVo 
{
	// 멤버 �?��
	int product_no;
	String category_nm;
	String product_name;
	String represent_img;
	int selling_price;
	int cost_price;
	int stock;
	int all_sells;
	
	// ?�성??
	public VProduct_DeletedVo(){}
	
	public VProduct_DeletedVo(int product_no, String category_nm, String product_name,
			String represent_img, int selling_price, int cost_price, int stock,
			int all_sells) 
	{
		this.product_no = product_no;
		this.category_nm = category_nm;
		this.product_name = product_name;
		this.represent_img = represent_img;
		this.selling_price = selling_price;
		this.cost_price = cost_price;
		this.stock = stock;
		this.all_sells = all_sells;
	}

	// getter and setter
	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}
	
	public String getCategory_nm() {
		return category_nm;
	}

	public void setCategory_nm(String category_nm) {
		this.category_nm = category_nm;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getRepresent_img() {
		return represent_img;
	}

	public void setRepresent_img(String represent_img) {
		this.represent_img = represent_img;
	}

	public int getSelling_price() {
		return selling_price;
	}

	public void setSelling_price(int selling_price) {
		this.selling_price = selling_price;
	}

	public int getCost_price() {
		return cost_price;
	}

	public void setCost_price(int cost_price) {
		this.cost_price = cost_price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getAll_sells() {
		return all_sells;
	}

	public void setAll_sells(int all_sells) {
		this.all_sells = all_sells;
	}

	@Override
	public String toString() {
		return "VProduct_DeletedVo [product_no=" + product_no + ", product_name=" + product_name + ", represent_img="
				+ represent_img + ", selling_price=" + selling_price + ", cost_price=" + cost_price + ", stock=" + stock
				+ ", all_sells=" + all_sells + "]";
	}
}
