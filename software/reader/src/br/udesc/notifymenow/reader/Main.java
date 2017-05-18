/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader;

import br.udesc.notifymenow.reader.util.Conexao;
import br.udesc.notifymenow.reader.util.LogConfig;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
        LogConfig.defineLogger();

//        RssReader reader = RssReaderFactory.getRssReader();

//        List<Noticia> resposta = reader.retrieve("http://www.valor.com.br/rss");
//
//        for (Noticia feed : resposta) {
//            System.out.println(feed.getTitulo());
//            System.out.println(feed.getConteudo());
//            System.out.println(feed.getLink());
//            System.out.println(String.format("\n"));
//        }

        teste();
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
            Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        }
    }
}
