package br.edu.iftm.imobiliaria.util;

import br.edu.iftm.imobiliaria.util.mail.GmailBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author danilo
 */
public class MailUtil {
    
    public static void sendMail(String emailDest, String nomeDest, String emailRemet, String nomeRemet, String assunto, String corpo) {
        try {
            Properties props = System.getProperties();

            props.put("mail.smtp.host", "smtp.gmail.com"); 
//            props.put("mail.smtp.port", "25"); 
            props.put("mail.debug", "true"); 
            props.put("mail.smtp.auth", "true"); 
            props.put("mail.smtp.starttls.enable","true"); 
            props.put("mail.smtp.EnableSSL.enable","true");

            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");   
            props.setProperty("mail.smtp.socketFactory.fallback", "false");   
//            props.setProperty("mail.smtp.port", "465");   
            props.setProperty("mail.smtp.socketFactory.port", "465"); 
            
            Authenticator auth = new Authenticator() {

                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("dsalinux@gmail.com", "");
                }
            };
            
            Session session = Session.getDefaultInstance(props, auth);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailRemet, nomeRemet));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailDest, nomeDest));
            message.setSubject(assunto);
//            message.setContent(corpo, "text/plain");
            message.setContent(corpo, "text/html");
            
//            // connect to the transport
//            Transport transport = session.getTransport("smtps");
//            transport.connect("smtp.gmail.com", 465, "dsalinux@gmail.com", ""); // host, user, password
//            // send the msg and close the connection
//            transport.sendMessage(message, message.getAllRecipients());
//            transport.close();

            
            Transport.send(message);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        sendMail("dsalinux@gmail.com", "Danilo", "dsalinux@gmail.com", 
                "Danilo Souza", "Testando", "<h1>Teste <b>teste</b>, teste</h1>");
        
        GmailBuilder gmail = new GmailBuilder();
        gmail.addParaQuem("dsalinux@gmail.com")
                .addCopiaCom("saulo8245@gmail.com")
                .addCopiaOculta("marcelladj17@gmail.com")
                .setAssunto("Teste de Envio de email")
                .setMensagem("<h1>Olá como vai</h1>")
                .enviar();
    }
}