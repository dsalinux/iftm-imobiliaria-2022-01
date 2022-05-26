package br.edu.iftm.imobiliaria.util.mail;

import java.util.Properties;

/**
 *
 * @author danilo
 */
public abstract class MailBuilder {

    private Properties props = System.getProperties();

    public MailBuilder(String smtpHost) {
        setSmtpHost(smtpHost);
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        
    }

    public MailBuilder setSmtpHost(String host) {
        props.put("mail.smtp.host", host);
        return this;
    }

    public MailBuilder setSmtpPort(String port) {
        props.put("mail.smtp.port", port);
        return this;
    }

    public MailBuilder setSmtpAuth(boolean auth) {
        props.put("mail.smtp.auth", auth);
        return this;
    }

    public MailBuilder setStartTLS(boolean startTls) {
        props.put("mail.smtp.starttls.enable", startTls);
        return this;
    }

    public MailBuilder setEnableSSL(boolean enableSSL) {
        props.put("mail.smtp.EnableSSL.enable", true);
        return this;
    }

    public MailBuilder setPortSocket(String port){
        props.put("mail.smtp.socketFactory.port", port);
        return this;
    }

    public Properties getProps() {
        return props;
    }
    
}
