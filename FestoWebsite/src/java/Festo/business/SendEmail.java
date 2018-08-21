/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Festo.business;

import java.util.Properties;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**
 *
 * @author cesar
 */
public class SendEmail {
    public static void sendFromGMail(String body, String file, String filename) throws AddressException, MessagingException{
        
        String username = "ccesarito720";
        String password ="Cesar809";    
        String recipient = "johnny.mieses@stonybrook.edu";
        String subject = "Gripper Finger Design Selection";
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host.", host);
        props.put("mail.smtp.user",username);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        
        try{
            message.setFrom(new InternetAddress(username));
            InternetAddress toAddress = new InternetAddress(recipient);
            
            message.addRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject(subject);
           // message.setText(body);
           
           BodyPart messageBodyPart = new MimeBodyPart();
           messageBodyPart.setText(body);
           
           // Create multipart message 
           Multipart multipart = new MimeMultipart();
           multipart.addBodyPart(messageBodyPart);
           
           // Part two is attachment
           messageBodyPart = new MimeBodyPart();
           DataSource source = new FileDataSource(file);
           messageBodyPart.setContent(multipart);
           messageBodyPart.setFileName(filename); // have to use substring to get real file name.
           multipart.addBodyPart(messageBodyPart);
           
           // Send the complete message parts
           message.setContent(multipart);
           
           
            Transport transport = session.getTransport("smtp");
            transport.connect(host,username,password);
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
           
        }catch(AddressException ae){
           ae.printStackTrace();
        }catch(MessagingException me){
            me.printStackTrace();
        }
    }
    public static void testEmailGMail() throws AddressException, MessagingException{
        Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    Session session = Session.getDefaultInstance(props, null);
    session.setDebug(true);
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress("ccesarito720@from.com"));
    msg.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress("johnny.mieses@stonybrook.edu")});
    msg.setSubject("Subject Line");
    msg.setText("Text Body");
    Transport.send(msg);
    }
}
