/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader;

import br.udesc.notifymenow.reader.controller.rss.RssReader;
import br.udesc.notifymenow.reader.controller.rss.RssReaderFactory;
import br.udesc.notifymenow.reader.model.bo.NoticiaBo;
import br.udesc.notifymenow.reader.model.dao.AssuntoDao;
import br.udesc.notifymenow.reader.model.dao.NoticiaDao;
import br.udesc.notifymenow.reader.model.dao.SiteDao;
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import br.udesc.notifymenow.reader.model.entity.Assunto;
import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.model.entity.Site;
import br.udesc.notifymenow.reader.util.Logger;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Main {

    public static void main(String[] args) throws MalformedURLException {
//        testeAssunto();
//        testeSite();
//        testeNoticia();
//        testeFeed();
//        showData("Qua, 21 Jun 2017 02:30:00 -0300");
//        showData("Wed, 21 Jun 2017 03:03:36 -0300");
//        showData("21 Jun 2017 01:42:00");

//        seed();
//        envia();
    }

    private static void envia() {
        NoticiaBo bo = new NoticiaBo(DaoFactory.getNoticia());
        bo.atualiza();
        bo.enviaEmail();
    }

    private static void showData(String data) {
        SimpleDateFormat format;
        if (data.length() > 25) {
            if (data.contains("Sun") || data.contains("Mon") || data.contains("Tue") || data.contains("Wed") || data.contains("Thu") || data.contains("Fri") || data.contains("Sat")) {
                format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
            } else {
                format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", new Locale("pt","BR"));
            }
        } else {
            format = new SimpleDateFormat("dd MMM yyyy HH:mm:ss", Locale.ENGLISH);
        }
        try {
            System.out.println(format.parse(data));
        } catch (ParseException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void testeFeed() {
        RssReader reader = RssReaderFactory.getRssReader();
        String site;
        site = "http://www.valor.com.br/rss";
        site = "http://rss.uol.com.br/feed/economia.xml";
        site = "http://www.infomoney.com.br/ultimas-noticias/rss";

        for (Noticia noticia : reader.retrieve(site)) {
            System.out.println(noticia.getTitulo());
            System.out.println(noticia.getLink());
            System.out.println(noticia.getDataFormatada());
            System.out.println(noticia.getConteudo());
            System.out.println("");
        }
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

    private static void seed() {
        Site site = new Site();
        site.setLink("http://www.valor.com.br/rss");
        site.setNome("Valor");

        SiteDao siteDao = DaoFactory.getSite();
        siteDao.salva(site);

        site.setId(0);
        site.setLink("http://rss.uol.com.br/feed/economia.xml");
        site.setNome("UOL");
        // esse não funciona
//        siteDao.salva(site);

        site.setId(0);
        site.setLink("http://www.infomoney.com.br/ultimas-noticias/rss");
        site.setNome("Money");
        siteDao.salva(site);


        Assunto assunto = new Assunto();
        assunto.setNome("governo");

        AssuntoDao assuntoDao = DaoFactory.getAssunto();
        assuntoDao.salva(assunto);
    }
}
