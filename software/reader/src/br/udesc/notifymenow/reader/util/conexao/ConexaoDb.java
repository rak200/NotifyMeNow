/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util.conexao;

import java.sql.ResultSet;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public interface ConexaoDb {

    abstract public Integer executa(String sql);

    abstract public ResultSet busca(String sql);

}
