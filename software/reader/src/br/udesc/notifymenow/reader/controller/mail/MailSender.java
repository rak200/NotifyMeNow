/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.mail;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public interface MailSender {

    abstract public void addRecipient(String address);

    abstract public void setSubject(String subject);

    abstract public void setContent(String content);

    abstract public void send();

    abstract public void send(String from, String subject, String content);
}
