/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.dao;

import br.udesc.notifymenow.reader.model.Site;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public interface SiteDao {

    public boolean salva(Site site);

    public boolean exclui(Site site);

    public List<Site> lista();

    public Site busca(int id);

}
