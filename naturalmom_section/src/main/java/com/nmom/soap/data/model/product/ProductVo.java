package com.nmom.soap.data.model.product;

public class ProductVo 
{
	// 멤버 변수
	int product_no;
	String product_name;
	int selling_price;
	int cost_price;
	int stock;
	int display_state;
	int sale_state;
	String represent_img;
	String detail_img;
	String summary_ex;
	String detail_ex;
	int deleted_state;
	int weight;
	int category_cd;
	
	// 생성자
	public ProductVo() {}
	
	// 모두 입력: 상품 등록 시
	public ProductVo(int product_no, String product_name, int selling_price,
			int cost_price, int stock, int display_state, int sale_state,
			String represent_img, String detail_img, String summary_ex,
			String detail_ex, int deleted_state, int weight, int category_cd)
	{
		this.product_no = product_no;
		this.product_name = product_name;
		this.selling_price = selling_price;
		this.cost_price = cost_price;
		this.stock = stock;
		this.display_state = display_state;
		this.sale_state = sale_state;
		this.represent_img = represent_img;
		this.detail_img = detail_img;
		this.summary_ex = summary_ex;
		this.detail_ex = detail_ex;
		this.deleted_state = deleted_state;
		this.weight = weight;
		this.category_cd = category_cd;
	}
	
	// 삭제 상태 없음 (삭제 상태 false로 설정): 상품 수정 시 내용 가져오기 및 상품 수정할 때
//	public ProductVo(int product_no, String product_name, int selling_price,
//			int cost_price, int stock, int display_state, int sale_state,
//			String represent_img, String detail_img, String summary_ex,
//			String detail_ex, int weight, int category_cd)
//	{
//		this.product_no = product_no;
//		this.product_name = product_name;
//		this.selling_price = selling_price;
//		this.cost_price = cost_price;
//		this.stock = stock;
//		this.display_state = display_state;
//		this.sale_state = sale_state;
//		this.represent_img = represent_img;
//		this.detail_img = detail_img;
//		this.summary_ex = summary_ex;
//		this.detail_ex = detail_ex;
//		this.deleted_state = 0;
//		this.weight = weight;
//		this.category_cd = category_cd;
//	}
	
	// getter and setter
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
	public int getDisplay_state() {
		return display_state;
	}
	public void setDisplay_state(int display_state) {
		this.display_state = display_state;
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
	public String getDetail_img() {
		return detail_img;
	}
	public void setDetail_img(String detail_img) {
		this.detail_img = detail_img;
	}
	public String getSummary_ex() {
		return summary_ex;
	}
	public void setSummary_ex(String summary_ex) {
		this.summary_ex = summary_ex;
	}
	public String getDetail_ex() {
		return detail_ex;
	}
	public void setDetail_ex(String detail_ex) {
		this.detail_ex = detail_ex;
	}
	public int getDeleted_state() {
		return deleted_state;
	}
	public void setDeleted_state(int deleted_state) {
		this.deleted_state = deleted_state;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCategory_cd() {
		return category_cd;
	}
	public void setCategory_cd(int category_cd) {
		this.category_cd = category_cd;
	}

	@Override
	public String toString() {
		return "ProductVo [product_no=" + product_no + ", product_name=" + product_name + ", selling_price="
				+ selling_price + ", cost_price=" + cost_price + ", stock=" + stock + ", display_state=" + display_state
				+ ", sale_state=" + sale_state + ", represent_img=" + represent_img + ", detail_img=" + detail_img
				+ ", summary_ex=" + summary_ex + ", detail_ex=" + detail_ex + ", deleted_state=" + deleted_state
				+ ", weight=" + weight + ", category_cd=" + category_cd + "]";
	}
}
