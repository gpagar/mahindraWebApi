package com.ganesh.mahindra.mail; 
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
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
import javax.mail.util.ByteArrayDataSource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class MailMail {
	 
	
	@Scheduled(cron = "0 0-58/2 * * * ?") 
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

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
	    ByteArrayOutputStream outputStream = null;

		try {
			Store mailStore = session.getStore(mailStoreType);
			mailStore.connect(emailSMTPserver, username, password); 
						
			Message mimeMessage = new MimeMessage(session); 
			  mimeMessage.setFrom(new InternetAddress(username)); 
			  mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(("maheshgaidhani94@gmail.com"))); 
			  mimeMessage.setSubject("Mahindra ");  
			  
			  MimeBodyPart messagePart = new MimeBodyPart();
	          messagePart.setText("PFA of PM Targets");
	          //now write the PDF content to the output stream
	          outputStream = new ByteArrayOutputStream();
	          writePdf(outputStream);
	          byte[] bytes = outputStream.toByteArray();

	          //construct the pdf body part
	          DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
			  
	          MimeBodyPart attachmentPart = new MimeBodyPart();
	          attachmentPart.setDataHandler(new DataHandler(dataSource));
	          attachmentPart.setFileName("MIS.pdf");
	          
	          Multipart multipart = new MimeMultipart(); 
	          multipart.addBodyPart(attachmentPart);
	          multipart.addBodyPart(messagePart);
	          
	          mimeMessage.setContent(multipart); 
			  Transport.send(mimeMessage);
			  
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	/*
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
*/
	public static void writePdf(OutputStream outputStream) throws Exception {
	
		Document document = new Document(PageSize.A3);
		PdfWriter writer = null;

		try {
			writer = PdfWriter.getInstance(document, outputStream);
		} catch (DocumentException e) {

			e.printStackTrace();
		}
		PdfPTable table = new PdfPTable(16);
		try {
			table.setWidthPercentage(100);
			table.setWidths(new float[] {3.0f, 2.0f,2.0f,2.0f, 1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f });
			Font headFont1 = new Font(FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.WHITE);
			Font f = new Font(FontFamily.TIMES_ROMAN, 10.0f, Font.UNDERLINE, BaseColor.BLUE);
			Font headFont = new Font(FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK);
			
			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Activities", headFont1));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Units", headFont1));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("F-19 Target L5", headFont1));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("F-19 Target L3", headFont1));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Apr-18", headFont1));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("May-18", headFont1));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Jun-18", headFont1));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Jul-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			
			hcell = new PdfPCell(new Phrase("Aug-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Sept-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Oct-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Nov-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Dec-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Jan-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("Feb-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			hcell = new PdfPCell(new Phrase("March-18", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			PdfPCell cell;

			cell = new PdfPCell(new Phrase(String.valueOf("Engine Loss due to Breakdown"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("Breakdown incidences - Total"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Breakdown time - Total"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf("Hrs./ Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Open Breakdowns"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Minor Stoppage Incidences"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("MTBF"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Total Time/ Incidences \r\n" + 
					"(Hrs)"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("MTTR"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Total BD time/incidences \r\n" + 
					"(Hrs)"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("Fixed cost"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Rs.Lacs"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("PM  compliance"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("%"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("TBM compliance"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("%"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			document.open();
			Paragraph company = new Paragraph("PM Targets",f);
			company.setAlignment(Element.ALIGN_CENTER);
			document.add(company);
			document.add(new Paragraph("\n "));
			DateFormat DF = new SimpleDateFormat("dd-MM-yyyy");
			document.add(new Paragraph("\n "));
			String reportDate = DF.format(new Date());
			document.add(new Paragraph("Date: "+reportDate));
			document.add(table);
			document.close();
			
		
			}catch (Exception e) {
			e.printStackTrace();
			}
		
	}
}
