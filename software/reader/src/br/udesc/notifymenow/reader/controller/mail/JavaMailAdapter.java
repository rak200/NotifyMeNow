/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.mail;

import br.udesc.notifymenow.reader.util.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
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

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class JavaMailAdapter implements MailSender {

    private final String USERNAME = "app.notifymenow@gmail.com";
    private final String PASSWORD = "notifymenowpw";

    private Properties properties;
    private final List<String> recipient;
    private String subject;
    private String content;

    public JavaMailAdapter() {
        recipient = new ArrayList<>();
    }

    public Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");
        }
        return properties;
    }

    private Authenticator getAuth() {
        return new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        };
    }

    @Override
    public void addRecipient(String address) {
        recipient.add(address);
    }

    @Override
    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void send() {
        try {
            Message msg = new MimeMessage(Session.getInstance(getProperties(), getAuth()));
            msg.setFrom(new InternetAddress(USERNAME));
            for (String address : recipient) {
                msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
            }
            msg.setSubject(subject);
            toHtml(msg);
            Transport.send(msg);

        } catch (AddressException ex) {
            Logger.error(ex);
        } catch (MessagingException | IOException ex) {
            Logger.error(ex);
        }
    }

    @Override
    public void send(String recipient, String subject, String content) {
        setContent(content);
        setSubject(subject);
        addRecipient(recipient);
        send();
    }

     public void toHtml(Message msg) throws IOException, MessagingException {
	StringBuilder sb = new StringBuilder();
	sb.append("<HTML>\n");
	sb.append("<HEAD>\n");
	sb.append("<TITLE>\n");
	sb.append(subject + "\n");
	sb.append("</TITLE>\n");
	sb.append("</HEAD>\n");
	sb.append("<BODY>\n");
        sb.append(content + "\n");
	sb.append("</BODY>\n");
	sb.append("</HTML>\n");
	msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString(), "text/html")));
    }
}
