/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader;

import br.udesc.notifymenow.reader.controller.rss.RssReaderFactory;
import br.udesc.notifymenow.reader.controller.rss.RssReader;
import br.udesc.notifymenow.reader.model.Noticia;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
        RssReader reader = RssReaderFactory.getRssReader();

        List<Noticia> resposta = reader.retrieve("http://www.valor.com.br/rss");

        for (Noticia feed : resposta) {
            System.out.println(feed.getTitulo());
            System.out.println(feed.getConteudo());
            System.out.println(feed.getLink());
            System.out.println(String.format("\n"));
        }
    }

}
