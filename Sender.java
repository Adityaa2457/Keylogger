package handlers;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*; 

public class Sender {
	private Sender(){}
	
	// Sender's email ID needs to be mentioned
    private static final String from = "hackermico28@gmail.com";
    // Recipient's email ID needs to be mentioned.
    private static final String to = "hackermico28@gmail.com";
    // Assuming you are sending email through Gmail's SMTP server
    private static final String host = "smtp.gmail.com";
    // Get system properties
    private static Properties properties = System.getProperties();
    // Setup mail server
    private static Session mailSess;
    private static MimeMessage mailMessage;
    public static void MailSender(String emailBody){
        
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        // Get the default Session object.
        mailSess = Session.getDefaultInstance(properties, new Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("hackermico28@gmail.com", "fwez tqgg xkbu iqha");
            }
        });
        try {
            // Create a default MimeMessage object.
            mailMessage = new MimeMessage(mailSess);
            // Set From: header field of the header.
            mailMessage.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            mailMessage.setSubject("This is the Subject Line!");
            // Now set the actual message
            mailMessage.setContent(emailBody,"text/html");
            // Send message
            Transport transport =mailSess.getTransport("smtp");
            transport.connect("smtp.gmail.com",from,"fwez tqgg xkbu iqha");
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
