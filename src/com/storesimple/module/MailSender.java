package com.storesimple.module;


import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

/*發送Email模組*/
public class MailSender extends Authenticator{
	private final String SMTPHOST ="smtp.gmail.com";//Google mail SMTP伺服器 協助發送信件
	private final String USERNAME;//寄件人的mail
	private final String PASSWORD;//寄件人的密碼
	private Session session;
	
	public MailSender(String userName, String password) {
		this.USERNAME = userName;
		this.PASSWORD = password;
		initialize(); 
	}
		
	private void initialize() {
		Properties props = new Properties();//Hashtable的一個子類，用於keys和values之間的映射
		props.setProperty("mail.transport.protocol","smtp");//必須選擇協議
		props.setProperty("mail.smtp.host",SMTPHOST);
		props.setProperty("mail.smtp.auth", "true");//請求身分驗證 必須要為true
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");  
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");   
		
		session = Session.getDefaultInstance(props,this);	
	}
	
	protected PasswordAuthentication getPasswordAuthentication() {//身分驗證 是繼承 Authenticator 的子方法    
		return new PasswordAuthentication(USERNAME,PASSWORD);     
	}     
	
	public synchronized void sendMail(String subject, String body, String sender, String recipients) throws AddressException, MessagingException {
		/*設置信的相關內容*/
		MimeMessage message = new MimeMessage(session);
		DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(),"text/plain"));//設置信的內容
		message.setSender(new InternetAddress(sender));//寄件人的mail
		message.setSubject(subject);//設置信的主題
		message.setDataHandler(handler);
	
		if (recipients.indexOf(',') > 0){    
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipients));//設置收信人的mail     
		}else{    
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));   
		}
		
		/*發送Email*/
		Transport transport = session.getTransport("smtp");
		transport.connect(SMTPHOST,465,USERNAME, PASSWORD);
		transport.sendMessage(message,message.getAllRecipients());
		transport.close();
	}

}
