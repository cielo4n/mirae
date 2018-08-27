package com.nmom.soap.svc.member;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.nmom.soap.data.model.member.MyEmail;



public class MyEmailNotiImple implements IMailRegistrationNotification{
	
	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	
	// Implements method
	@Override
	public void sendMyEmail(final MyEmail me) {
//		SimpleMailMessage smm = new SimpleMailMessage();
//		smm.setTo(me.getTo());
//		smm.setFrom(me.getFrom());;
//		smm.setSubject(me.getSubject());
//		try{
////			mailSender.send(smm);
//		}catch(MailException e){
//			e.printStackTrace();
//		}
		
		 MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            public void prepare(MimeMessage mimeMessage) throws Exception {
	                MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, "UTF-8");
	 
	                message.setTo(me.getTo());
	                message.setFrom(me.getFrom()); // could be parameterized...
	                message.setSubject(me.getSubject());
	                Map<String, Object> model = new HashMap<>();
	                model.put("pw", me.getText());
	                String text = VelocityEngineUtils.mergeTemplateIntoString(
	                        velocityEngine, "mail_form.html", "UTF-8",
	                        model);
	                message.setText(text, true);
	            }
	        };
	     try{
	     mailSender.send(preparator);
	     }catch(MailException e){
	    	 e.printStackTrace();
	    	 System.out.println("전송실패");
	     }
	}

}
