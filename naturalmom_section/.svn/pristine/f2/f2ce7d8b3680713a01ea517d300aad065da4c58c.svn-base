package com.nmom.soap.data.model.member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.nmom.soap.S;

public class MemberVo {
	
	String mem_id;
	String mem_pw;
	String mem_name;
	String mem_phone;
	String mem_addr_post;
	String mem_addr_detail;
	String mem_email;
	Date mem_birth;
	int mem_gender;
	int drop_out;
	int mem_level_cd;
	
	
	// 생성자
	public MemberVo() {  }

	// 모두
	public MemberVo(String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_addr_post,
			String mem_addr_detail, String mem_email, Date mem_birth, int mem_gender, int drop_out,
			int mem_level_cd) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_addr_post = mem_addr_post;
		this.mem_addr_detail = mem_addr_detail;
		this.mem_email = mem_email;
		this.mem_birth = mem_birth;
		this.mem_gender = mem_gender;
		this.drop_out = drop_out;
		this.mem_level_cd = mem_level_cd;
	}
	
	// 탈퇴여부 0 // 회원등급 1
	public MemberVo(String mem_id, String mem_pw, String mem_name, String mem_phone, String mem_addr_post,
			String mem_addr_detail, String mem_email, Date mem_birth, int mem_gender) {
		super();
		this.mem_id = mem_id;
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_addr_post = mem_addr_post;
		this.mem_addr_detail = mem_addr_detail;
		this.mem_email = mem_email;
		this.mem_birth = mem_birth;
		this.mem_gender = mem_gender;
		this.drop_out = 0;
		this.mem_level_cd = 1;
	}

	
	// getter and setter
	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pw() {
		return mem_pw;
	}

	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public String getMem_phone() {
		return mem_phone;
	}

	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}

	public String getMem_addr_post() {
		return mem_addr_post;
	}

	public void setMem_addr_post(String mem_addr_post) {
		this.mem_addr_post = mem_addr_post;
	}

	public String getMem_addr_detail() {
		return mem_addr_detail;
	}

	public void setMem_addr_detail(String mem_addr_detail) {
		this.mem_addr_detail = mem_addr_detail;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public Date getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}

	public int getMem_gender() {
		return mem_gender;
	}

	public void setMem_gender(int mem_gender) {
		this.mem_gender = mem_gender;
	}

	public int getDrop_out() {
		return drop_out;
	}

	public void setDrop_out(int drop_out) {
		this.drop_out = drop_out;
	}

	public int getMem_level_cd() {
		return mem_level_cd;
	}

	public void setMem_level_cd(int mem_level_cd) {
		this.mem_level_cd = mem_level_cd;
	}
	
	
	public MemberVo edit_member_form(String id, String pw, String phone, String postNum, String address, String email){
		this.mem_id= id;
		this.mem_pw = pw;
		this.mem_phone = phone;
		this.mem_addr_post = postNum;
		this.mem_addr_detail = address;
		this.mem_email = email;
		return this;
	}
	
	
}
