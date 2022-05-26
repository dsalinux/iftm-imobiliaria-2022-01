package br.edu.iftm.imobiliaria.util.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
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
public class GmailBuilder extends MailBuilder {

    private String mailUser;
    private String passUser;
    private String nameUser;
    private List<String> copiaOculta;
    private List<String> copiaCom;
    private List<String> paraQuem;
    private String assunto;
    private String mensagem;

    public GmailBuilder() {
        super("smtp.gmail.com");
        setEnableSSL(true);
        setStartTLS(true);
        setSmtpAuth(true);
        setPortSocket("465");
        setSmtpPort("465");
        mailUser = "imobiliariaiftm@gmail.com";
        passUser = "danilo321";
        nameUser = "Imobialiária";
    }

    public GmailBuilder setNameUser(String nameUser) {
        this.nameUser = nameUser;
        return this;
    }

    public GmailBuilder setMailUser(String mailUser) {
        this.mailUser = mailUser;
        return this;
    }

    public GmailBuilder setPassUser(String passUser) {
        this.passUser = passUser;
        return this;
    }

    public GmailBuilder addCopiaOculta(String copiaOculta) {
        if (this.copiaOculta == null) {
            this.copiaOculta = new ArrayList<>();
        }
        this.copiaOculta.add(copiaOculta);
        return this;
    }

    public GmailBuilder addCopiaCom(String copiaCom) {
        if (this.copiaCom == null) {
            this.copiaCom = new ArrayList<>();
        }
        this.copiaCom.add(copiaCom);
        return this;
    }

    public GmailBuilder addParaQuem(String paraQuem) {
        if (this.paraQuem == null) {
            this.paraQuem = new ArrayList<>();
        }
        this.paraQuem.add(paraQuem);
        return this;
    }

    public GmailBuilder setAssunto(String assunto) {
        this.assunto = assunto;
        return this;
    }

    public GmailBuilder setMensagem(String mensagem) {
        this.mensagem = mensagem;
        return this;
    }

    public void enviar() {
        try {
            Authenticator auth = new Authenticator() {
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(mailUser, passUser);
                }
            };
            
            Session session = Session.getDefaultInstance(getProps(), auth);
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailUser, nameUser));
            if(copiaCom != null){
                Address[] addr = new InternetAddress[copiaCom.size()];
                for (int i = 0; i < copiaCom.size(); i++) {
                    addr[i] = new InternetAddress(copiaCom.get(i));
                }
                message.addRecipients(Message.RecipientType.CC, addr);
            }
            if(copiaOculta != null){
                Address[] addr = new InternetAddress[copiaOculta.size()];
                for (int i = 0; i < copiaOculta.size(); i++) {
                    addr[i] = new InternetAddress(copiaOculta.get(i));
                }
                message.addRecipients(Message.RecipientType.BCC, addr);
            }
            if(paraQuem != null){
                Address[] addr = new InternetAddress[paraQuem.size()];
                for (int i = 0; i < paraQuem.size(); i++) {
                    addr[i] = new InternetAddress(paraQuem.get(i));
                }
                message.addRecipients(Message.RecipientType.TO, addr);
            }
            message.setSubject(assunto);
            message.setContent(mensagem, "text/html");
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(GmailBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(GmailBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
