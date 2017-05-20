/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao.sqlite;

import br.udesc.notifymenow.reader.model.Noticia;
import br.udesc.notifymenow.reader.model.Site;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class NoticiaDao implements br.udesc.notifymenow.reader.model.dao.NoticiaDao {

    @Override
    public boolean salva(Noticia noticia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean exclui(Noticia noticia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noticia> lista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Noticia busca(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noticia> listaPorSite(Site site) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Noticia> listaPorEnvio(boolean enviado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
