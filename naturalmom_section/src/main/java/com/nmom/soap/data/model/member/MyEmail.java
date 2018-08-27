package com.nmom.soap.data.model.member;

// email_form.jsp
// form에서 전달되는 내용을 담을 객체
public class MyEmail {
	
	String from;
	String to;
	String subject;
	String text;
	
	// cc, bcc
	// 첨부파일 MIME처리
	
	public MyEmail() {	}

	public MyEmail(String from, String to, String subject, String text) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	
	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getText() {
		return text;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
