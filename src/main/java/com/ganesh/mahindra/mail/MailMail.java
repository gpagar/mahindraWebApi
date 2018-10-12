package com.ganesh.mahindra.mail; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
 
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailMail {
	 
	/*<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-mail</artifactId>
</dependency>*/
	    /*@Scheduled(cron = "0/10 * * * * ?") */
	public static void sendFileThoughMail() {
		
		final String emailSMTPserver = "smtp.gmail.com";
		final String emailSMTPPort = "587";
		final String mailStoreType = "imaps";
		final String username = "akshaykasar72@gmail.com";
		final String password = "mh151889";

		System.out.println("username" + username);
		System.out.println("password" + password);

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Store mailStore = session.getStore(mailStoreType);
			mailStore.connect(emailSMTPserver, username, password); 
			
			String attachmentName = "E:/EMaintainence/pdf/1210201811262169logo.jpg";
			
			Message mimeMessage = new MimeMessage(session); 
			  mimeMessage.setFrom(new InternetAddress(username)); 
			  mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(("akshaykasar72@gmail.com"))); 
			  mimeMessage.setSubject("Check Mahindra ");  
			  
			  MimeBodyPart messagePart = new MimeBodyPart();
	          messagePart.setText("Send Mail through Boot logo");
			  
			  FileDataSource fileDataSource = new FileDataSource(attachmentName); 
	          MimeBodyPart attachmentPart = new MimeBodyPart();
	          attachmentPart.setDataHandler(new DataHandler(fileDataSource));
	          attachmentPart.setFileName(fileDataSource.getName()); 
	          Multipart multipart = new MimeMultipart(); 
	          multipart.addBodyPart(attachmentPart);
	          multipart.addBodyPart(messagePart);
	          
	          mimeMessage.setContent(multipart); 
			  Transport.send(mimeMessage);
			  
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	
public static void sendMsgThoughMail(String msg) {
		
		final String emailSMTPserver = "smtp.gmail.com";
		final String emailSMTPPort = "587";
		final String mailStoreType = "imaps";
		final String username = "akshaykasar72@gmail.com";
		final String password = "mh151889";

		System.out.println("username" + username);
		System.out.println("password" + password);

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Store mailStore = session.getStore(mailStoreType);
			mailStore.connect(emailSMTPserver, username, password); 
			 
			
			Message mimeMessage = new MimeMessage(session); 
			  mimeMessage.setFrom(new InternetAddress(username)); 
			  mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(("akshaykasar72@gmail.com"))); 
			  mimeMessage.setSubject("Check Mahindra ");  
			  mimeMessage.setText(msg);
			  
			  Transport.send(mimeMessage);
			  
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
