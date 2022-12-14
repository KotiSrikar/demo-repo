package com.te.lms.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Email {
	
	@Bean
	public Email getEmail() {
		Email email = new Email();
		return email;
	}
	
	public void sendEmail(String message,String emailId,String subject) {
		
		String host = "smtp.gmail.com";
		
		Properties properties = System.getProperties();
		
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(properties, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("koti.srikar8@gmail.com", "ftvpdzqslksqiqbb");
			}
		});
		
		session.setDebug(true);
		
		MimeMessage mimeMessage = new MimeMessage(session);
		
		try {
			mimeMessage.setFrom("koti.srikar8@gmail.com");
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailId));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(message);
			Transport.send(mimeMessage);
		} catch (MessagingException e) {
			System.out.println(e.getMessage());
			
		}
	}
}
