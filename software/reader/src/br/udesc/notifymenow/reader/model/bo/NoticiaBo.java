/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.model.bo;

import br.udesc.notifymenow.reader.controller.rss.RssReader;
import br.udesc.notifymenow.reader.controller.rss.RssReaderFactory;
import br.udesc.notifymenow.reader.model.dao.AssuntoDao;
import br.udesc.notifymenow.reader.model.dao.NoticiaDao;
import br.udesc.notifymenow.reader.model.dao.SiteDao;
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import br.udesc.notifymenow.reader.model.entity.Assunto;
import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.model.entity.Site;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class NoticiaBo {

    private NoticiaDao dao;
    private AssuntoDao assuntoDao;
    private SiteDao siteDao;

    public NoticiaBo(NoticiaDao dao) {
        this.dao = DaoFactory.getNoticia();
        this.assuntoDao = DaoFactory.getAssunto();
        this.siteDao = DaoFactory.getSite();
    }

    /**
     * busca e salva no banco de dados os feeds de todos os sites filtrando os assuntos
     */
    public void atualiza() {
        RssReader reader = RssReaderFactory.getRssReader();
        List<Assunto> assuntos = assuntoDao.lista();

        for (Site site : siteDao.lista()) {
            Date dataAtualizacao = dao.ultimaAtualizacao(site);

            

            for (Noticia feed : reader.retrieve(site.getLink(), dataAtualizacao)) {
                for (Assunto assunto : assuntos) {
                    if (feed.getConteudo().contains(assunto.getNome())) {
                        dao.salva(feed);
                        break;
                    }
                }
            }
        }

    }

    public void enviaEmail() {

    }

    public List<Noticia> listaNaoEnviados() {
        return dao.lista(false);
    }

    public List<Noticia> lista() {
        return dao.lista();
    }

}
