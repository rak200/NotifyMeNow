/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.sqlite;

import br.udesc.notifymenow.reader.model.Site;
import br.udesc.notifymenow.reader.model.Site;
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
public class SiteDao implements br.udesc.notifymenow.reader.model.dao.SiteDao {

    @Override
    public boolean salva(Site site) {
        if (site.getId() > 0) {
            altera(site);
        }
        return insere(site);
    }

    @Override
    public boolean exclui(Site site) {
        String comando = "delete from site where id = ?";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setInt(1, site.getId());
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return Conexao.getInstance().executa(stm.toString()) > 0;
    }

    @Override
    public List<Site> lista() {
        ArrayList<Site> lista = new ArrayList<>();
        String comando = "select id, nome, link from site";
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
    public Site busca(int id) {
        String comando = "select id, nome, link from site where id = ?";
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

    private boolean insere(Site site) {
        String comando = "insert into site (nome, link) values (?, ?) returning id";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setString(1, site.getNome());
            stm.setString(2, site.getLink());
            ResultSet resultado = Conexao.getInstance().busca(stm.toString());
            if (resultado.next()){
                site.setId(resultado.getInt("id"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return false;
    }

    private boolean altera(Site site) {
        String comando = "update site set nome = ?, link = ? where id = ?";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setString(1, site.getNome());
            stm.setString(2, site.getLink());
            stm.setInt(3, site.getId());
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return Conexao.getInstance().executa(stm.toString()) > 0;
    }

    private Site novo(ResultSet resultado) throws SQLException {
        Site site = new Site();
        site.setId(resultado.getInt("id"));
        site.setNome(resultado.getString("nome"));
        site.setLink(resultado.getString("link"));
        return site;
    }



}
