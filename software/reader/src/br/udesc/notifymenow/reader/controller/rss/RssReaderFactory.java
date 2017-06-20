/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.controller.rss;

/**
 *
 * @author Ricardo Augusto Küstner
 */
abstract public class RssReaderFactory {

    public static RssReader getRssReader() {
//        return new RssRomeAdapter(); // não retorna a data corretamente
        return new RssSimpleFeedParserAdapter();
    }
}
