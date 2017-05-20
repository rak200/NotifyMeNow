/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.sqlite;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class DaoFactory {

    public static br.udesc.notifymenow.reader.model.dao.NoticiaDao getNoticia() {
        return new NoticiaDao();
    }

    public static br.udesc.notifymenow.reader.model.dao.SiteDao getSite() {
        return new SiteDao();
    }

    public static br.udesc.notifymenow.reader.model.dao.AssuntoDao getAssunto() {
        return new AssuntoDao();
    }

}
