/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.rss;

import br.udesc.notifymenow.reader.model.entity.Noticia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public interface RssReader {

    /**
     * retrieve posts and prevent from furure requests to return de same data
     * @param url URL from RSS origin
     * @return
     */
    public List<Noticia> retrieve(String url);

    /**
     * retrieve posts.
     * @param url URL from RSS origin
     * @param cache determine if future requests will get the same data
     * @return
     */
    public List<Noticia> retrieve(String url, boolean cache);

    /**
     * retrieve posts.
     * @param url URL from RSS origin
     * @param date determine the lowest date to search
     * @return
     */
    public List<Noticia> retrieve(String url, Date date);

}
