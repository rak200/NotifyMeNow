/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao;

import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.model.entity.Site;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public interface NoticiaDao {

    public boolean salva(Noticia noticia);

    public boolean exclui(Noticia noticia);

    public Noticia busca(int id);

    public List<Noticia> lista();

    public List<Noticia> lista(Site site);

    public List<Noticia> lista(boolean enviado);

    public Date ultimaAtualizacao(Site site);
}
