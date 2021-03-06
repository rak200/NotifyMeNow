/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.sqlite;

import br.udesc.notifymenow.reader.util.FileUtil;
import br.udesc.notifymenow.reader.util.Logger;
import br.udesc.notifymenow.reader.util.Property;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class ConexaoSqlite implements br.udesc.notifymenow.reader.util.conexao.ConexaoDb {

    public static final String DB_FILE = Property.get("banco_dados_pasta") + "/nmn.db";

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
            executa(FileUtil.getContent(Property.get("banco_dados_pasta") + "/DDL.sql"));
            Logger.info("Base de dados criada!");
        }
    }

    @Override
    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return getConnection().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
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

    @Override
    public Integer executa(String sql) {
        try {
            return getStatment().executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    @Override
    public Integer executa(PreparedStatement sql) {
        try {
            return sql.executeUpdate();
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    @Override
    public ResultSet busca(String sql) {
        try {
            return getStatment().executeQuery(sql);
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    @Override
    public ResultSet busca(PreparedStatement sql) {
        try {
            return sql.executeQuery();
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
