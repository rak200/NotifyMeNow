/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util;

import br.udesc.notifymenow.reader.Main;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Seeder {
    public static void checkDb() {
        if (!hasTable()) {
            Logger.getLogger("Reader").log(Level.SEVERE, "Criando base de dados!");
            Conexao.getInstance().executa(getContent("db/DDL.sql"));
            Logger.getLogger("Reader").log(Level.SEVERE, "Base de dados criada!");
        }
    }

    private static boolean hasTable() {
        String comado = "SELECT name FROM sqlite_master WHERE type='table' AND name='assunto'";
        try {
            return Conexao.getInstance().busca(comado).next();
        } catch (SQLException ex) {
            Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static String getContent(String file) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(file));
            try {
                String line = reader.readLine();

                while (line != null) {
                    builder.append(line);
                    builder.append(System.lineSeparator());
                    line = reader.readLine();
                }
                String everything = builder.toString();
            } catch (IOException ex) {
                Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
            }
        }

        return builder.toString();
    }
}
