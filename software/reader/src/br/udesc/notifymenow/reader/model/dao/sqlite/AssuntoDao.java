/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.sqlite;

import br.udesc.notifymenow.reader.model.Assunto;
import br.udesc.notifymenow.reader.util.Logger;
import br.udesc.notifymenow.reader.util.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class AssuntoDao implements br.udesc.notifymenow.reader.model.dao.AssuntoDao {

    @Override
    public boolean salva(Assunto assunto) {
        if (assunto.getId() > 0) {
            altera(assunto);
        }
        return insere(assunto);
    }

    @Override
    public boolean exclui(Assunto assunto) {
        String comando = "delete from assunto where id = ?";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setInt(1, assunto.getId());
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return Conexao.getInstance().executa(stm.toString()) > 0;
    }

    @Override
    public List<Assunto> lista() {
        ArrayList<Assunto> lista = new ArrayList<>();
        String comando = "select id, nome from assunto";
        PreparedStatement stm = Conexao.getInstance().getPreperedStatement(comando);
        try {
            ResultSet resultado = Conexao.getInstance().busca(stm.toString());
            while (resultado.next()){
                lista.add(novo(resultado));
            }
            return lista;
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    @Override
    public Assunto busca(int id) {
        String comando = "select id, nome from assunto where id = ?";
        PreparedStatement stm = Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setInt(1, id);
            ResultSet resultado = Conexao.getInstance().busca(stm.toString());
            if (resultado.next()){
                return novo(resultado);
            }
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return null;
    }

    private boolean insere(Assunto assunto) {
        String comando = "insert into assunto (nome) values (?) returning id";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setString(1, assunto.getNome());
            ResultSet resultado = Conexao.getInstance().busca(stm.toString());
            if (resultado.next()){
                assunto.setId(resultado.getInt("id"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return false;
    }

    private boolean altera(Assunto assunto) {
        String comando = "update assunto set nome = ? where id = ?";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setString(1, assunto.getNome());
            stm.setInt(2, assunto.getId());
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return Conexao.getInstance().executa(stm.toString()) > 0;
    }

    private Assunto novo(ResultSet resultado) throws SQLException {
        Assunto assunto = new Assunto();
        assunto.setId(resultado.getInt("id"));
        assunto.setNome(resultado.getString("nome"));
        return assunto;
    }

}
