package com.ae.qa.util;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
	 import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
	 import javax.mail.Session;
	 import javax.mail.Transport;
	 import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.ae.qa.base.TestBase;

public class SendMail extends TestBase{
	public void sendExtentReport()
	 {
	 // recipient’s address
	// String to = "kalyani.gomkale69@gmail.com";
	// sender’s address
	 String from = "kalyani.gomkale@automationedge.com";
	 //sender's credential
	final String username = prop.getProperty("SenderAddress");
	final String password = prop.getProperty("SenderPswd");
	 // Provide host,port,smtp/tls and its protocol
	 String host = "smtp.office365.com";
	 Properties props = new Properties();
	 props.put("mail.smtp.auth", "true");
	 props.put("mail.smtp.starttls.enable", "true");
	 props.put("mail.smtp.host", host);
	 props.put("mail.smtp.port", "587");
	 // Get the Session object.
	 Session session = Session.getInstance(props,
	 new javax.mail.Authenticator() {
	 protected PasswordAuthentication getPasswordAuthentication() {
	 return new PasswordAuthentication(username, password);
	 }
	 });
	 session.setDebug(true);
	 try {
	 // Create a default MimeMessage object.
	 Message message = new MimeMessage(session);
	 // Set From: header field
	 message.setFrom(new InternetAddress(from));
	 // Set To: header field
	 message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(prop.getProperty("ReceiptentAddress")));
	 // Set Subject: header field
	 message.setSubject("Test Automation Report");
	 // Create the message part
    BodyPart messageBodyPart = new MimeBodyPart();

    // Now actual message
    messageBodyPart.setText("PFA extent report executed on AE UI :"+prop.getProperty("UIVersion")+" and AE Server: "
    +prop.getProperty("ServerVersion"));
	 // Create a multipart message 
    Multipart multipart = new MimeMultipart();
    // Set text message part
    multipart.addBodyPart(messageBodyPart);
    // Part two is attachment
    messageBodyPart = new MimeBodyPart();
    String filename =System.getProperty("user.dir") + "/test-output/AEExtentReport.html";
    DataSource source = new FileDataSource(filename);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(filename);
    multipart.addBodyPart(messageBodyPart);
    // Send the complete message parts
    message.setContent(multipart);
	 // Send message
	 System.out.println("Sending report on email");
	 Transport.send(message);
	 System.out.println("Email Sent successfully....");
	 } catch (MessagingException e) {
	 throw new RuntimeException(e);
	 }
}

}
