package com.ganesh.mahindra.mail; 
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.ganesh.mahindra.model.BreakdownMonthwise;
import com.ganesh.mahindra.model.BreakdownTarget;
import com.ganesh.mahindra.model.BreakdownTimeMonthwise;
import com.ganesh.mahindra.model.PmPlan;
import com.ganesh.mahindra.model.calibration.CalibrationDetails;
import com.ganesh.mahindra.model.tbm.TbmData;
import com.ganesh.mahindra.repository.BreakdownMonthwiseRepository;
import com.ganesh.mahindra.repository.BreakdownMonthwiseTimeRepository;
import com.ganesh.mahindra.repository.BreakdownTargetRepository;
import com.ganesh.mahindra.repository.PmPlanRepository;
import com.ganesh.mahindra.repository.calibration.GetCalibrationRepository;
import com.ganesh.mahindra.repository.tbm.TbmDataRepository;
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
	 
	@Autowired
	BreakdownMonthwiseRepository breakdownMonthwiseRepository;
	@Autowired
	BreakdownMonthwiseTimeRepository breakdownMonthwiseTimeRepository;
	@Autowired
	BreakdownTargetRepository breakdownTargetRepository;
	@Autowired
	PmPlanRepository pmPlanRepository;
	@Autowired
	TbmDataRepository tbmDataRepository;
	@Autowired
	GetCalibrationRepository getCalibrationRepository;
	@Scheduled(cron = "0 0/30 * * * ?") 
	public void sendFileThoughMail() {
		
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
			  mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(("PATIL.RESHMA@mahindra.com"))); 
			  mimeMessage.setSubject("MIS Sheet");  
			  
			  MimeBodyPart messagePart = new MimeBodyPart();
	          messagePart.setText("PFA of PM Targets");
	          //now write the PDF content to the output stream
	          outputStream = new ByteArrayOutputStream();
	          writePdf(outputStream,1);//deptId=1
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
		/*try {
			Store mailStore = session.getStore(mailStoreType);
			mailStore.connect(emailSMTPserver, username, password); 
						
			  Message mimeMessage = new MimeMessage(session); 
			  mimeMessage.setFrom(new InternetAddress(username)); 
			  mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(("maheshgaidhani94@gmail.com"))); 
			  mimeMessage.setSubject("MIS Sheet");  
			  
			  MimeBodyPart messagePart = new MimeBodyPart();
	          messagePart.setText("PFA of PM Targets");
	          //now write the PDF content to the output stream
	          outputStream = new ByteArrayOutputStream();
	          writePdf(outputStream,2);
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
		}*/

	/*	try {
			Store mailStore = session.getStore(mailStoreType);
			mailStore.connect(emailSMTPserver, username, password); 
						
			  Message mimeMessage = new MimeMessage(session); 
			  mimeMessage.setFrom(new InternetAddress(username)); 
			  mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(("maheshgaidhani94@gmail.com"))); 
			  mimeMessage.setSubject("MIS Sheet");  
			  
			  MimeBodyPart messagePart = new MimeBodyPart();
	          messagePart.setText("PFA of PM Targets");
	          //now write the PDF content to the output stream
	          outputStream = new ByteArrayOutputStream();
	          writePdf(outputStream,3);
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
*/
	}
	@Scheduled(cron = "0 0/30 * * * ?") 
      public  void sendMsgThoughMail() {
		
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
         for(int m=1;m<4;m++) {
		try {
			 Store mailStore = session.getStore(mailStoreType);
			 mailStore.connect(emailSMTPserver, username, password); 
			 String[] monthName = {"January", "February",
		                "March", "April", "May", "June", "July",
		                "August", "September", "October", "November",
		                "December"};

		        Calendar cal = Calendar.getInstance();
		        String month = monthName[cal.get(Calendar.MONTH)];
			
			 Message mimeMessage = new MimeMessage(session); 

			  mimeMessage.setFrom(new InternetAddress(username)); 
			  mimeMessage.addRecipient(Message.RecipientType.TO,new InternetAddress(("PATIL.RESHMA@mahindra.com"))); 
			  mimeMessage.setSubject(month+"-Schedule");  
			  //MimeBodyPart messagePart = new MimeBodyPart();
	          //messagePart.setText("PM Schedule");
			  List<PmPlan> getPmMaintenancePlan = new ArrayList<PmPlan>();
			  List<TbmData> tbmDataList=new ArrayList<>();
			  List<CalibrationDetails> eqCalDetailsList=new ArrayList<>();
				try

				{
					getPmMaintenancePlan = pmPlanRepository.findByCurrentMonth((Calendar.getInstance().get(Calendar.MONTH)+1),m);
					tbmDataList=tbmDataRepository.getTbmDataSchedule(m);
					 eqCalDetailsList=getCalibrationRepository.findCalibrationDataForSchedule(m);
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			  StringBuilder email=new StringBuilder();
			  email.append("<html><body>"
	                    + "<table style='border:2px solid black' border=1>");
			  email.append("<tr bgcolor=\"#ffae4c\">");
	            email.append("<th style='text-align:center;' colspan=2>");
	            email.append("PM");
	            email.append("</th>");
	            email.append("</tr>");
	            email.append("<tr bgcolor=\"#ffae4c\">");
	            email.append("<th>");
	            email.append("Machine Name");
	            email.append("</th>");

	            email.append("<th>");
	            email.append("M/C No.");
	            email.append("</th>");
	      
	            email.append("</tr>");
	            for(int i=0;i<getPmMaintenancePlan.size();i++) {
	            email.append("<tr>");
	            email.append("<th>");
	            email.append(""+getPmMaintenancePlan.get(i).getMachinName());
	            email.append("</th>");

	            email.append("<th>");
	            email.append(""+getPmMaintenancePlan.get(i).getMachineNo());
	            email.append("</th>");
	      
	            email.append("</tr>");
	            }
	            email.append("</table></body></html><br>");

	            StringBuilder email1=new StringBuilder();
				  email1.append("<html><body>"
		                    + "<table style='border:2px solid black' border=1>");
				  email1.append("<tr bgcolor=\"#ffae4c\">");
		            email1.append("<th style='text-align:center;' colspan=4>");
		            email1.append("TBM");
		            email1.append("</th>");
		            email1.append("</tr>");
		            email1.append("<tr bgcolor=\"#ffae4c\">");
		            email1.append("<th>");
		            email1.append("Machine Name");
		            email1.append("</th>");

		            email1.append("<th>");
		            email1.append("M/C No.");
		            email1.append("</th>");
		            
		            email1.append("<th>");
		            email1.append("Location");
		            email1.append("</th>");
		            
		            email1.append("<th>");
		            email1.append("Item");
		            email1.append("</th>");
		      
		            email1.append("</tr>");
		            for(int i=0;i<tbmDataList.size();i++) {
		            email1.append("<tr>");
		            email1.append("<th>");
		            email1.append(""+tbmDataList.get(i).getMachineName());
		            email1.append("</th>");

		            email1.append("<th>");
		            email1.append(""+tbmDataList.get(i).getMachineNo());
		            email1.append("</th>");
		      

		            email1.append("<th>");
		            email1.append(""+tbmDataList.get(i).getLocationName());
		            email1.append("</th>");
		      

		            email1.append("<th>");
		            email1.append(""+tbmDataList.get(i).getItemName());
		            email1.append("</th>");
		      
		            email1.append("</tr>");
		            }
		            email1.append("</table></body></html><br>");
		            
		            StringBuilder email2=new StringBuilder();
					  email2.append("<html><body>"
			                    + "<table style='border:2px solid black' border=1>");
					  email2.append("<tr bgcolor=\"#ffae4c\">");
					  email2.append("<th style='text-align:center;' colspan=4>");
					  email2.append("CALIBRATION");
					  email2.append("</th>");
					  email2.append("</tr>");
					  email2.append("<tr bgcolor=\"#ffae4c\">");
					
					  email2.append("<th>");
					  email2.append("EQUIPMENT");
					  email2.append("</th>");
			            
					  email2.append("<th>");
					  email2.append("SERIAL NO.");
					  email2.append("</th>");
			            
					  email2.append("<th>");
					  email2.append("M&M CARD NO.");
					  email2.append("</th>");
					  
					  email2.append("<th>");
					  email2.append("M/C No");
					  email2.append("</th>");
					
			      
					  email2.append("</tr>");
			            for(int i=0;i<eqCalDetailsList.size();i++) {
			            	email2.append("<tr>");
			            	email2.append("<th>");
			            	email2.append(""+eqCalDetailsList.get(i).getEqName());
			            	email2.append("</th>");

			            	email2.append("<th>");
			            	email2.append(""+eqCalDetailsList.get(i).getSrNo());
			            	email2.append("</th>");
			      

			            	email2.append("<th>");
			            	email2.append(""+eqCalDetailsList.get(i).getCardNo());
			            	email2.append("</th>");
			      

			            	email2.append("<th>");
			            	email2.append(""+eqCalDetailsList.get(i).getMachineNo());
			            	email2.append("</th>");
			            
			      
			            	email2.append("</tr>");
			            }
			            email2.append("</table></body></html>");
		            
				mimeMessage.setContent(""+email+""+email1+""+email2, "text/html");

			    Transport.send(mimeMessage);
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;
         }
		
	}

  	public static float roundUp(float d) {
  		return BigDecimal.valueOf(d).setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
  	}

	public  void writePdf(OutputStream outputStream,int deptId) throws Exception {
	
		Document document = new Document(PageSize.A3);
		PdfWriter writer = null;

		try {
			writer = PdfWriter.getInstance(document, outputStream);
		} catch (DocumentException e) {

			e.printStackTrace();
		}
		String currYear="";
		RestTemplate rest = new RestTemplate();
	
		java.util.Date date= new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH)+1;
		String fromMonth="";int monthNo=month;
		String toMonth="";
		int currentYear=0;
		  String year = new SimpleDateFormat("yyyy").format(new Date());
		if(month>3)
		{
			fromMonth = new SimpleDateFormat("yyyy").format(new Date());
			int intYear =Integer.parseInt(fromMonth);
			toMonth=(intYear+1)+"";
			currentYear=Integer.parseInt(year);
			currentYear=currentYear+1;
			currYear=(Integer.parseInt(new SimpleDateFormat("yy").format(new Date()))+1)+"";
			monthNo=monthNo-3;
		}
		else
		{
			toMonth = new SimpleDateFormat("yyyy").format(new Date());
			int intYear =Integer.parseInt(toMonth);
			fromMonth=(intYear-1)+"";
			currentYear=Integer.parseInt(year);
			currYear=new SimpleDateFormat("yy").format(new Date());
			if(month==1)
			{
				monthNo=10;
			}else if(month==2)
			{
				monthNo=11;
			}else
			{
				monthNo=12;
			}
		}
		
		BreakdownMonthwise minorStoppages=breakdownMonthwiseRepository.getMonthwiseBreakdowns( fromMonth+"-04", fromMonth+"-05",fromMonth+"-06",fromMonth+"-07",fromMonth+"-08",fromMonth+"-09",fromMonth+"-10",fromMonth+"-11",fromMonth+"-12",toMonth+"-01",toMonth+"-02", toMonth+"-03",deptId);
		
		BreakdownTimeMonthwise mtbf=breakdownMonthwiseTimeRepository.getAllBrekMonthwiseTimeBreakdowns( fromMonth+"-04", fromMonth+"-05",fromMonth+"-06",fromMonth+"-07",fromMonth+"-08",fromMonth+"-09",fromMonth+"-10",fromMonth+"-11",fromMonth+"-12",toMonth+"-01",toMonth+"-02", toMonth+"-03",deptId);

		BreakdownTimeMonthwise engineLoss=breakdownMonthwiseTimeRepository.getAllBrekMonthwiseELBreakdowns(fromMonth+"-04", fromMonth+"-05",fromMonth+"-06",fromMonth+"-07",fromMonth+"-08",fromMonth+"-09",fromMonth+"-10",fromMonth+"-11",fromMonth+"-12",toMonth+"-01",toMonth+"-02", toMonth+"-03",deptId);

		BreakdownMonthwise allBreak=breakdownMonthwiseRepository.getAllBrekMonthwiseBreakdowns(fromMonth+"-04", fromMonth+"-05",fromMonth+"-06",fromMonth+"-07",fromMonth+"-08",fromMonth+"-09",fromMonth+"-10",fromMonth+"-11",fromMonth+"-12",toMonth+"-01",toMonth+"-02", toMonth+"-03",deptId);

		BreakdownTarget minorTarget = new BreakdownTarget();
		BreakdownTarget aRankTarget = new BreakdownTarget();
		BreakdownTarget allTarget = new BreakdownTarget();
		BreakdownTarget timeTarget = new BreakdownTarget();
		BreakdownTarget mtbfTarget= new BreakdownTarget();BreakdownTarget mttrTarget= new BreakdownTarget();BreakdownTarget elTarget= new BreakdownTarget();
		try
		{
			minorTarget = breakdownTargetRepository.findByStatusAndGraphTypeAndExIntAndYear(1,1,deptId,currentYear);
			aRankTarget = breakdownTargetRepository.findByStatusAndGraphTypeAndExIntAndYear(1,2,deptId,currentYear);
			allTarget = breakdownTargetRepository.findByStatusAndGraphTypeAndExIntAndYear(1,3,deptId,currentYear);
			timeTarget = breakdownTargetRepository.findByStatusAndGraphTypeAndExIntAndYear(1,4,deptId,currentYear);
			mtbfTarget = breakdownTargetRepository.findByStatusAndGraphTypeAndExIntAndYear(1,5,deptId,currentYear);
			mttrTarget = breakdownTargetRepository.findByStatusAndGraphTypeAndExIntAndYear(1,6,deptId,currentYear);
			elTarget = breakdownTargetRepository.findByStatusAndGraphTypeAndExIntAndYear(1,7,deptId,currentYear);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		PdfPTable table = new PdfPTable(17);
		try {
			table.setWidthPercentage(100);
			table.setWidths(new float[] {3.0f, 2.0f,2.0f,2.0f, 1.0f, 1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f,1.0f });
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
			
			hcell = new PdfPCell(new Phrase("Avg-19", headFont1)); 
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			hcell.setBackgroundColor(BaseColor.GRAY);
			table.addCell(hcell);
			
			PdfPCell cell;

			cell = new PdfPCell(new Phrase(String.valueOf("Engine Loss due to Breakdown"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBackgroundColor(BaseColor.PINK);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(roundUp(elTarget.getTargetL5()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp(elTarget.getTargetL3()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime1())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime2())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime3())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime4())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime5())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime6())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime7())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime8())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime9())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime10())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime11())), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(engineLoss.getBreakdownTime12())), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			float eLossTotal=(engineLoss.getBreakdownTime1()+engineLoss.getBreakdownTime2()+engineLoss.getBreakdownTime3()+engineLoss.getBreakdownTime4()+engineLoss.getBreakdownTime5()+engineLoss.getBreakdownTime6()+engineLoss.getBreakdownTime7()+engineLoss.getBreakdownTime8()+engineLoss.getBreakdownTime9()+engineLoss.getBreakdownTime10()+engineLoss.getBreakdownTime11()+engineLoss.getBreakdownTime12())/monthNo;
			cell = new PdfPCell(new Phrase(roundUp(eLossTotal)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Breakdown incidences - Total"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(roundUp(allTarget.getTargetL5()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp(allTarget.getTargetL3()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt1())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt2())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt3())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt4())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt5())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt6())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt7())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt8())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt9())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt10())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt11())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(allBreak.getBreakdownCnt12())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			float allBreakTotal=allBreak.getBreakdownCnt1()+allBreak.getBreakdownCnt2()+allBreak.getBreakdownCnt3()+allBreak.getBreakdownCnt4()+allBreak.getBreakdownCnt5()+allBreak.getBreakdownCnt6()+allBreak.getBreakdownCnt7()+allBreak.getBreakdownCnt8()+allBreak.getBreakdownCnt9()+allBreak.getBreakdownCnt10()+allBreak.getBreakdownCnt11()+allBreak.getBreakdownCnt12();

			cell = new PdfPCell(new Phrase(roundUp(allBreakTotal/monthNo)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Breakdown time - Total"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf("Hrs./ Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp(timeTarget.getTargetL5()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp(timeTarget.getTargetL3()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime1()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime2()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime3()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime4()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime5()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime6()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime7()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime8()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime9()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime10()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime11()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime12()/60))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			float mtbfTotal=(mtbf.getBreakdownTime1()/60)+(mtbf.getBreakdownTime2()/60)+(mtbf.getBreakdownTime3()/60)+(mtbf.getBreakdownTime4()/60)+(mtbf.getBreakdownTime5()/60)+(mtbf.getBreakdownTime6()/60)+(mtbf.getBreakdownTime7()/60)+(mtbf.getBreakdownTime8()/60)+(mtbf.getBreakdownTime9()/60)+(mtbf.getBreakdownTime10()/60)+(mtbf.getBreakdownTime11()/60)+(mtbf.getBreakdownTime12()/60);

			cell = new PdfPCell(new Phrase(roundUp(mtbfTotal/monthNo)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Open Breakdowns"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase("0", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase("0", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Minor Stoppage Incidences"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Nos./Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((minorTarget.getTargetL5()/12))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp((minorTarget.getTargetL3()/12))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt1())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt2())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt3())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt4())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt5())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt6())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt7())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt8())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt9())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt10())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt11())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(roundUp(minorStoppages.getBreakdownCnt12())+""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			float minorStoppageTotal=(minorStoppages.getBreakdownCnt1()+minorStoppages.getBreakdownCnt2()+minorStoppages.getBreakdownCnt3()+minorStoppages.getBreakdownCnt4()+minorStoppages.getBreakdownCnt5()+minorStoppages.getBreakdownCnt6()+minorStoppages.getBreakdownCnt7()+minorStoppages.getBreakdownCnt8()+minorStoppages.getBreakdownCnt9()+minorStoppages.getBreakdownCnt10()+minorStoppages.getBreakdownCnt11()+minorStoppages.getBreakdownCnt12());
			cell = new PdfPCell(new Phrase(roundUp(minorStoppageTotal/monthNo)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("MTBF"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Total Time/ Incidences \r\n" + 
					"(Hrs)"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(roundUp(mtbfTarget.getTargetL5()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp(mtbfTarget.getTargetL3()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			float mtbfTotals=0;
			if(mtbf.getBreakdownCnt1()>0) {
			cell = new PdfPCell(new Phrase(roundUp((720/mtbf.getBreakdownCnt1()))+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			mtbfTotals=mtbfTotals+(720/mtbf.getBreakdownCnt1());
			}else
			{
				cell = new PdfPCell(new Phrase("0", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);	
			}
			
			if(mtbf.getBreakdownCnt2()>0) {
				cell = new PdfPCell(new Phrase(roundUp((744/mtbf.getBreakdownCnt2()))+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(744/mtbf.getBreakdownCnt2());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			if(mtbf.getBreakdownCnt3()>0) {
				cell = new PdfPCell(new Phrase(roundUp(720/mtbf.getBreakdownCnt3())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(720/mtbf.getBreakdownCnt3());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt4()>0) {
				cell = new PdfPCell(new Phrase(roundUp(744/mtbf.getBreakdownCnt4())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(744/mtbf.getBreakdownCnt4());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}

			
			
			if(mtbf.getBreakdownCnt5()>0) {
				cell = new PdfPCell(new Phrase(roundUp(744/mtbf.getBreakdownCnt5())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(744/mtbf.getBreakdownCnt5());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt6()>0) {
				cell = new PdfPCell(new Phrase(roundUp(720/mtbf.getBreakdownCnt6())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(720/mtbf.getBreakdownCnt6());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			if(mtbf.getBreakdownCnt7()>0) {
				cell = new PdfPCell(new Phrase(roundUp(744/mtbf.getBreakdownCnt7())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(744/mtbf.getBreakdownCnt7());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			if(mtbf.getBreakdownCnt8()>0) {
				cell = new PdfPCell(new Phrase(roundUp(720/mtbf.getBreakdownCnt8())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(720/mtbf.getBreakdownCnt8());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			

			if(mtbf.getBreakdownCnt9()>0) {
				cell = new PdfPCell(new Phrase(roundUp(744/mtbf.getBreakdownCnt9())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(744/mtbf.getBreakdownCnt9());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt10()>0) {
				cell = new PdfPCell(new Phrase(roundUp(744/mtbf.getBreakdownCnt10())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(744/mtbf.getBreakdownCnt10());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt11()>0) {
				cell = new PdfPCell(new Phrase(roundUp(720/mtbf.getBreakdownCnt11())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(720/mtbf.getBreakdownCnt11());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			if(mtbf.getBreakdownCnt12()>0) {
				cell = new PdfPCell(new Phrase(roundUp(744/mtbf.getBreakdownCnt12())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mtbfTotals=mtbfTotals+(744/mtbf.getBreakdownCnt12());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			cell = new PdfPCell(new Phrase(roundUp(mtbfTotals/monthNo)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("MTTR"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Total BD time/incidences \r\n" + 
					"(Hrs)"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);cell.setBackgroundColor(BaseColor.PINK);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(roundUp(mttrTarget.getTargetL5()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(roundUp(mttrTarget.getTargetL3()/12)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			float mttrTotal=0.0f;
			if(mtbf.getBreakdownCnt1()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime1()/60)/mtbf.getBreakdownCnt1())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime1()/60)/mtbf.getBreakdownCnt1());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			if(mtbf.getBreakdownCnt2()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime2()/60)/mtbf.getBreakdownCnt2())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime2()/60)/mtbf.getBreakdownCnt2());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt3()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime3()/60)/mtbf.getBreakdownCnt3())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime3()/60)/mtbf.getBreakdownCnt3());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt4()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime4()/60)/mtbf.getBreakdownCnt4())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime4()/60)/mtbf.getBreakdownCnt4());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt5()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime5()/60)/mtbf.getBreakdownCnt5())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime5()/60)/mtbf.getBreakdownCnt5());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt6()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime6()/60)/mtbf.getBreakdownCnt6())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime6()/60)/mtbf.getBreakdownCnt6());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt7()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime7()/60)/mtbf.getBreakdownCnt7())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime7()/60)/mtbf.getBreakdownCnt7());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt8()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime8()/60)/mtbf.getBreakdownCnt8())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime8()/60)/mtbf.getBreakdownCnt8());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			if(mtbf.getBreakdownCnt9()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime9()/60)/mtbf.getBreakdownCnt9())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime9()/60)/mtbf.getBreakdownCnt9());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			if(mtbf.getBreakdownCnt10()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime10()/60)/mtbf.getBreakdownCnt10())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime10()/60)/mtbf.getBreakdownCnt10());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			if(mtbf.getBreakdownCnt11()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime11()/60)/mtbf.getBreakdownCnt11())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime11()/60)/mtbf.getBreakdownCnt11());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			
			if(mtbf.getBreakdownCnt12()>0) {
				cell = new PdfPCell(new Phrase(roundUp((mtbf.getBreakdownTime12()/60)/mtbf.getBreakdownCnt12())+"", headFont));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setPaddingRight(8);
				table.addCell(cell);
				mttrTotal=mttrTotal+((mtbf.getBreakdownTime12()/60)/mtbf.getBreakdownCnt12());
				}else
				{
					cell = new PdfPCell(new Phrase("0", headFont));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
					cell.setPaddingRight(8);
					table.addCell(cell);	
				}
			
			cell = new PdfPCell(new Phrase(roundUp(mttrTotal/monthNo)+"", headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Fixed cost"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Rs.Lacs"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("PM  compliance"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);cell.setBackgroundColor(BaseColor.PINK);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("%"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("TBM compliance"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("%"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			

			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf(""), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("No. of MTBF / MTTR kaizens"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);cell.setBackgroundColor(BaseColor.PINK);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("Nos/Month"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("B rank Zero breakdown machine"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("%"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);cell.setBackgroundColor(BaseColor.PINK);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			cell = new PdfPCell(new Phrase(String.valueOf("0"), headFont));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingRight(8);
			table.addCell(cell);
			
			document.open();
			Paragraph company = new Paragraph("MIS",f);
			company.setAlignment(Element.ALIGN_CENTER);
			document.add(company);
			DateFormat DF = new SimpleDateFormat("dd-MM-yyyy");
			String reportDate = DF.format(new Date());
			document.add(new Paragraph("Date: "+reportDate));
			document.add(new Paragraph("\n "));

			document.add(table);
			document.close();
			
		
			}catch (Exception e) {
			e.printStackTrace();
			}
		
	}
}
