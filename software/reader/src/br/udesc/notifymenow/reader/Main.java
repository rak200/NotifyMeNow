/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader;

import br.udesc.notifymenow.reader.model.dao.AssuntoDao;
import br.udesc.notifymenow.reader.model.dao.NoticiaDao;
import br.udesc.notifymenow.reader.model.dao.SiteDao;
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import br.udesc.notifymenow.reader.model.entity.Assunto;
import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.model.entity.Site;
import br.udesc.notifymenow.reader.util.Logger;
import java.net.MalformedURLException;
import java.util.Date;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
//        testeAssunto();
//        testeSite();
//        testeNoticia();
    }

    private static void testeNoticia() {
        NoticiaDao dao = DaoFactory.getNoticia();

        Noticia noticia = new Noticia();
        noticia.setTitulo("titulo 1");
        noticia.setLink("link 1");
        noticia.setConteudo("conteudo 1");
        noticia.setData(new Date());
        noticia.setSite(new Site());
        noticia.getSite().setId(1);
        dao.salva(noticia);
        Logger.info("inserido");

        for (Noticia item : dao.lista()) {
            Logger.info(item.getId() + " - " + item.getTitulo() + " - " + item.getLink() + " - " + item.getConteudo() + " - " + item.getDataFormatada() + " - " + item.isEnviado());
        }

        noticia.setId(0);
        noticia.setTitulo("titulo 2");
        noticia.setLink("link 2");
        noticia.setConteudo("conteudo 2");
        noticia.setData(new Date());
        noticia.setSite(new Site());
        noticia.getSite().setId(1);
        dao.salva(noticia);

        noticia.setTitulo("titulo 3");
        noticia.setLink("link 3");
        noticia.setConteudo("conteudo 3");
        noticia.setData(new Date());
        noticia.setSite(new Site());
        noticia.getSite().setId(1);
        noticia.setEnviado(true);
        dao.salva(noticia);
        Logger.info("alterado");
        for (Noticia item : dao.lista()) {
            Logger.info(item.getId() + " - " + item.getTitulo() + " - " + item.getLink() + " - " + item.getConteudo() + " - " + item.getDataFormatada() + " - " + item.isEnviado());
        }

        dao.exclui(noticia);
        Logger.info("exluido");
        for (Noticia item : dao.lista()) {
            Logger.info(item.getId() + " - " + item.getTitulo() + " - " + item.getLink() + " - " + item.getConteudo() + " - " + item.getDataFormatada() + " - " + item.isEnviado());
        }
    }

    private static void testeSite() {
        SiteDao dao = DaoFactory.getSite();

        Site site = new Site();
        site.setNome("vaca");
        site.setLink("link da vaca");
        dao.salva(site);
        Logger.info("inserido");

        for (Site site1 : dao.lista()) {
            Logger.info(site1.getId() + " - " + site1.getNome() + " - " + site1.getLink());
        }

        site.setId(0);
        site.setNome("nova vaca");
        site.setLink("novo link da vaca");
        dao.salva(site);

        site.setNome("vaca alterada");
        site.setLink("link da vaca alterado");
        dao.salva(site);
        Logger.info("alterado");

        for (Site site1 : dao.lista()) {
            Logger.info(site1.getId() + " - " + site1.getNome() + " - " + site1.getLink());
        }

        dao.exclui(site);
        Logger.info("exluido");
        for (Site site1 : dao.lista()) {
            Logger.info(site1.getId() + " - " + site1.getNome() + " - " + site1.getLink());
        }
    }

    private static void testeAssunto() {
        AssuntoDao dao = DaoFactory.getAssunto();

        Assunto assunto = new Assunto();
        assunto.setNome("vaca");

        dao.salva(assunto);
        Logger.info("vaca salva");

        for (Assunto item : dao.lista()) {
            Logger.info(item.getId() + " - " + item.getNome());
        }

        assunto.setNome("vaca alterada");
        dao.salva(assunto);
        Logger.info("vaca alterada");


        assunto.setId(0);
        assunto.setNome("vaca nova");
        dao.salva(assunto);
        Logger.info("outra vaca");


        for (Assunto item : dao.lista()) {
            Logger.info(item.getId() + " - " + item.getNome());
        }

        dao.exclui(assunto);
        Logger.info("vaca morrida");
        for (Assunto item : dao.lista()) {
            Logger.info(item.getId() + " - " + item.getNome());
        }
    }

}
