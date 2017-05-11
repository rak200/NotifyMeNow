/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.rss;

import java.net.URL;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public interface RssReader {

    /**
     * retrieve posts and prevent from furure requests to return de same data
     * @param url URL from RSS origin
     */
    public void retrieve(URL url);

    /**
     * retrieve posts.
     * @param url URL from RSS origin
     * @param cache determine if future requests will get the same data
     */
    public void retrieve(URL url, boolean cache);

}
