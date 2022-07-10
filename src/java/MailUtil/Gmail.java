package MailUtil;

import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
        
public class Gmail {
    public void sendEmail(String to, String from,
            String subject, String body, boolean ishtml) throws AddressException, MessagingException{
        
        Properties properties = new Properties();
        properties.put("mail.transport.protocol","smtps");
        properties.put("mail.smtps.host", "smtp.gmail.com");
        properties.put("mail.smtps.port", 465);
        properties.put("mail.smtps.auth", "true");
        properties.put("mail.smtps.quitwait", "false");
        
        Session session = Session.getInstance(properties);
        session.setDebug(true);
        Message msg = new MimeMessage(session);
        
        if (ishtml){
            msg.setContent(body,"text/html");
            
        }
        else{
            msg.setText(body);
        }
 
        Address fromAdd = new InternetAddress(from);
        Address toAdd = new InternetAddress(to);
        
        msg.setFrom(fromAdd);
        msg.setRecipient(Message.RecipientType.TO, toAdd);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        
        Transport tran= session.getTransport();
        tran.connect("storediemmy@gmail.com","gcokevhdimtbhcif");
        tran.sendMessage(msg, msg.getAllRecipients());
        tran.close();
    }
}