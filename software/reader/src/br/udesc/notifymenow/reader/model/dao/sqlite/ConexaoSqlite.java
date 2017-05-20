/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.sqlite;

import br.udesc.notifymenow.reader.util.FileUtil;
import br.udesc.notifymenow.reader.util.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class ConexaoSqlite implements br.udesc.notifymenow.reader.model.dao.conexao.ConexaoDb {

    public static final String DB_FILE = "db/nmn.db";

    private final String DB_DRIVER = "jdbc:sqlite";

    private Connection conn;

    public ConexaoSqlite() {
        try {
            conn = DriverManager.getConnection(DB_DRIVER + ":" + DB_FILE);
            iniciaBanco();
        } catch (SQLException ex) {
            Logger.error(ex);
        }
    }

    private Connection getConnection() {
        return conn;
    }

    private void iniciaBanco() {
        if (!hasTable()) {
            Logger.info("Criando base de dados!");
            executa(FileUtil.getContent("db/DDL.sql"));
            Logger.info("Base de dados criada!");
        }
    }

    private Statement getStatment() {
        try {
            Statement stm = getConnection().createStatement();
            stm.setQueryTimeout(30);
            return stm;
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    public Integer executa(String sql) {
        try {
            return getStatment().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    public ResultSet busca(String sql) {
        try {
            return getStatment().executeQuery(sql);
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        getConnection().close();
    }

    private boolean hasTable() {
        String comado = "SELECT name FROM sqlite_master WHERE type='table' AND name='assunto'";
        try {
            return busca(comado).next();
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return false;
    }

}
