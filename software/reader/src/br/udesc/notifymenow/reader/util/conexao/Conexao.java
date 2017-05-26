/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util.conexao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Conexao {

    private ConexaoDb conexao;

    private Conexao() {
        conexao = ConexaoFactory.getConexao();
    }

    public static Conexao getInstance() {
        return ConexaoHolder.INSTANCE;
    }

    private static class ConexaoHolder {

        private static final Conexao INSTANCE = new Conexao();
    }

    public PreparedStatement getPreperedStatement(String sql) {
        return conexao.getPreparedStatement(sql);
    }

    public Integer executa(String sql) {
        return conexao.executa(sql);
    }

    public ResultSet busca(String sql) {
        return conexao.busca(sql);
    }
}
