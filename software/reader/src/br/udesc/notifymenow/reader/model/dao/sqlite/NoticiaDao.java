/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.sqlite;

import br.udesc.notifymenow.reader.model.Noticia;
import br.udesc.notifymenow.reader.model.Site;
import br.udesc.notifymenow.reader.util.Logger;
import br.udesc.notifymenow.reader.util.conexao.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class NoticiaDao implements br.udesc.notifymenow.reader.model.dao.NoticiaDao {

    @Override
    public boolean salva(Noticia noticia) {
        if (noticia.getId() > 0) {
            altera(noticia);
        }
        return insere(noticia);
    }

    @Override
    public boolean exclui(Noticia noticia) {
        String comando = "delete from noticia where idnoticia = ?";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            stm.setInt(1, noticia.getId());
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return Conexao.getInstance().executa(stm.toString()) > 0;
    }

    @Override
    public List<Noticia> lista() {
        ArrayList<Noticia> lista = new ArrayList<>();
        PreparedStatement stm = Conexao.getInstance().getPreperedStatement(getSelect());
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
    public Noticia busca(int id) {
        String comando = getSelect() + " where idnoticia = ?";
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

    @Override
    public List<Noticia> lista(Site site) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noticia> lista(boolean enviado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getSelect() {
        return "select noticia.idnoticia, noticia.titulo, noticia.conteudo, noticia.enviado,"
              + "      noticia.data, noticia.link, site.idsite, site.nome as nomesite, site.link as linksite"
              + " from noticia"
              + " left join site"
              + "   on site.idsite = noticia.idsite";
    }

    private boolean insere(Noticia noticia) {
        String comando = "insert into noticia (idsite, titulo, conteudo, link, data, enviado) values (?,?,?,?,?,?) returning idnoticia";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            setParametros(stm, noticia);
            ResultSet resultado = Conexao.getInstance().busca(stm.toString());
            if (resultado.next()){
                noticia.setId(resultado.getInt("id"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return false;
    }

    private boolean altera(Noticia noticia) {
        String comando = "update noticia "
                + "          set idsite = ?, "
                + "              titulo = ?, "
                + "              conteudo = ?, "
                + "              link = ?, "
                + "              data = ?, "
                + "              enviado = ? "
                + "        where idnoticia = ?";
        PreparedStatement stm =  Conexao.getInstance().getPreperedStatement(comando);
        try {
            setParametros(stm, noticia);
            stm.setInt(7, noticia.getId());
        } catch (SQLException ex) {
            Logger.error(ex);
        }
        return Conexao.getInstance().executa(stm.toString()) > 0;
    }

    private void setParametros(PreparedStatement stm, Noticia noticia) throws SQLException {
        stm.setInt(1, noticia.getSite().getId());
        stm.setString(2, noticia.getTitulo());
        stm.setString(3, noticia.getConteudo());
        stm.setString(4, noticia.getLink());
        stm.setDate(5, (Date) noticia.getData());
        if (noticia.isEnviado()) {
            stm.setInt(6, 1);
        } else {
            stm.setInt(6, 0);
        }
    }

    private Noticia novo(ResultSet resultado) throws SQLException {
        Noticia noticia = new Noticia();
        noticia.setId(resultado.getInt("idnoticia"));
        noticia.getSite().setId(resultado.getInt("idsite"));
        noticia.getSite().setNome(resultado.getString("nomesite"));
        noticia.getSite().setLink(resultado.getString("linksite"));
        noticia.setTitulo(resultado.getString("titulo"));
        noticia.setConteudo(resultado.getString("conteudo"));
        noticia.setData(resultado.getString("data"));
        noticia.setLink(resultado.getString("link"));
        noticia.setEnviado(resultado.getInt("enviado") == 1);
        return noticia;
    }



}
