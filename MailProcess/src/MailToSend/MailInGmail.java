package MailToSend;


import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;



public class MailInGmail {

	    public static void main(final String[] args) {
	        final String to = "receiver@gmail.com";
	        final String from = "sender@gmail.com";
	        final String host = "smtp.gmail.com";
	        final Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.port", "465");
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        final Session session = Session.getInstance(properties, (Authenticator)new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication("sender@gmail.com", "sender-password");
	            }
	        });
	        session.setDebug(true);
	        try {
	            final MimeMessage message = new MimeMessage(session);
	            message.setFrom((Address)new InternetAddress(from));
	            message.addRecipient(Message.RecipientType.TO, (Address)new InternetAddress(to));
	            message.setSubject("Email Project");
	            message.setText("Processed Successfully");
	            System.out.println("Processing");
	            Transport.send((Message)message);
	            System.out.println("Successfully Sent");
	        }
	        catch (MessagingException mex) {
	            mex.printStackTrace();
	        }
	    }
	}	
	

