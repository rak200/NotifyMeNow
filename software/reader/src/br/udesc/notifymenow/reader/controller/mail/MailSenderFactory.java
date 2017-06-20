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
abstract public class MailSenderFactory {

    public static MailSender getMailSender() {
        return new JavaMailAdapter();
    }
}
