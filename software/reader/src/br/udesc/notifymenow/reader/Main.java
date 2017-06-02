/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader;

import br.udesc.notifymenow.reader.controller.rss.RssReader;
import br.udesc.notifymenow.reader.controller.rss.RssReaderFactory;
import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.util.conexao.Conexao;
import br.udesc.notifymenow.reader.util.Logger;
import com.ernieyu.feedparser.Feed;
import com.ernieyu.feedparser.FeedException;
import com.ernieyu.feedparser.FeedParser;
import com.ernieyu.feedparser.FeedParserFactory;
import com.ernieyu.feedparser.Item;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
        Logger.defineLogger();
////        teste();

        RssReader reader = RssReaderFactory.getRssReader();

        List<Noticia> resposta = reader.retrieve("http://www.valor.com.br/rss");

        for (Noticia feed : resposta) {
            System.out.println(feed.getTitulo());
            System.out.println(feed.getConteudo());
            System.out.println(feed.getLink());
            System.out.println(feed.getDataFormatada());
            System.out.println(String.format("\n"));
        }
    }

    private static void teste() {

        Conexao cnx = Conexao.getInstance();
        cnx.executa("insert into assunto (nome) values('Java')");
        cnx.executa("insert into assunto (nome) values('PHP')");
        ResultSet rs = cnx.busca("select * from assunto");

        try {
            while (rs.next()) {
                System.out.println("nome = " + rs.getString("nome"));
                System.out.println("id = " + rs.getInt("idassunto"));
            }
        } catch (SQLException ex) {
            Logger.error(ex);
        }
    }
}
