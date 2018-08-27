package com.nmom.soap.data.model.member;

//멤버 주문자 정보
public class VOrdererVo {
	private String id;
	private String name;
	private String phone;
	private String email;
	private String addr_post;
	private String addr_detail;
	
	public VOrdererVo() {}

	public VOrdererVo(String name, String phone, String email, String addr_post, String addr_detail) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.addr_post = addr_post;
		this.addr_detail = addr_detail;
	}
	
	
	//전체
	public VOrdererVo(String id, String name, String phone, String email, String addr_post, String addr_detail) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.addr_post = addr_post;
		this.addr_detail = addr_detail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "VOrdererVo [name=" + name + ", phone=" + phone + ", email=" + email + ", addr_post=" + addr_post
				+ ", addr_detail=" + addr_detail + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr_post() {
		return addr_post;
	}

	public void setAddr_post(String addr_post) {
		this.addr_post = addr_post;
	}

	public String getAddr_detail() {
		return addr_detail.replaceAll("@", " ");
	}

	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}
	
}
