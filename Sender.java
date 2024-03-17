package handlers;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*; 

public class Sender {
	private Sender(){}
	
	
    private static final String from = "hackermico28@gmail.com";
    private static final String to = "hackermico28@gmail.com";
    private static final String host = "smtp.gmail.com";
    private static Properties properties = System.getProperties();
    private static Session mailSess;
    private static MimeMessage mailMessage;
    public static void MailSender(String emailBody){
        
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        mailSess = Session.getDefaultInstance(properties, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hackermico28@gmail.com", "xxxx xxxx xxxx xxxx");
            }
        });
        try {
            
            mailMessage = new MimeMessage(mailSess);
            mailMessage.setFrom(new InternetAddress(from));
            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mailMessage.setSubject("This is the Subject Line!");
            mailMessage.setContent(emailBody,"text/html");
            Transport transport =mailSess.getTransport("smtp");
            transport.connect("smtp.gmail.com",from,"fwez tqgg xkbu iqha");
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
