/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Conexao {

    static {
        Seeder.checkDb();
    }

    public static final String DB_FILE = "db/nmn.db";

    private final String DB_DRIVER = "jdbc:sqlite";

    private Connection conn;

    private Conexao() {
        try {
            conn = DriverManager.getConnection(DB_DRIVER + ":" + DB_FILE);
        } catch (SQLException ex) {
            Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        }
    }

    public static Conexao getInstance() {
        return ConexaoHolder.INSTANCE;
    }

    private Connection getConnection() {
        return conn;
    }

    private static class ConexaoHolder {
        private static final Conexao INSTANCE = new Conexao();
    }

    private Statement getStatment() {
        try {
            Statement stm = getConnection().createStatement();
            stm.setQueryTimeout(30);
            return stm;
        } catch (SQLException ex) {
            Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Integer executa(String sql) {
        try {
            return getStatment().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet busca(String sql) {
        try {
            return getStatment().executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        getConnection().close();
    }

}
