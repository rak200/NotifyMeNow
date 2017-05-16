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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

        teste();
    }

    private static teste() {
        Connection connection = null;
        try
        {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:db/nmn.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
            ResultSet rs = statement.executeQuery("select * from person");
            while(rs.next())
            {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
          }
          catch(SQLException e)
          {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
          }
          finally
          {
            try
            {
              if(connection != null)
                connection.close();
            }
            catch(SQLException e)
            {
              // connection close failed.
              System.err.println(e);
            }
        }
    }

}
