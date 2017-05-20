/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.conexao;

import br.udesc.notifymenow.reader.model.dao.sqlite.ConexaoSqlite;
import br.udesc.notifymenow.reader.util.Logger;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Conexao {

    private ConexaoDb conexao;

    private Conexao() {
        conexao = new ConexaoSqlite();
    }

    public static Conexao getInstance() {
        return ConexaoHolder.INSTANCE;
    }

    private static class ConexaoHolder {

        private static final Conexao INSTANCE = new Conexao();
    }

    public Integer executa(String sql) {
        return conexao.executa(sql);
    }

    public ResultSet busca(String sql) {
        return conexao.busca(sql);
    }
}
