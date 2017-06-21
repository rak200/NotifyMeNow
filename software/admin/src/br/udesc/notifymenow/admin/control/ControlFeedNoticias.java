/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.GrigFeedNoticias;
import br.udesc.notifymenow.admin.view.JDFeedNoticias;
import br.udesc.notifymenow.reader.controller.rss.RssReader;
import br.udesc.notifymenow.reader.controller.rss.RssReaderFactory;
import br.udesc.notifymenow.reader.model.entity.Noticia;
import br.udesc.notifymenow.reader.model.dao.NoticiaDao;
import br.udesc.notifymenow.reader.model.dao.SiteDao;
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import br.udesc.notifymenow.reader.model.entity.Site;
import br.udesc.notifymenow.reader.util.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Wagner
 */
public class ControlFeedNoticias {
    private NoticiaDao noticiaDao = DaoFactory.getNoticia();
    private Noticia noticia;
    private SiteDao siteDao = DaoFactory.getSite();
    JDFeedNoticias jdFeed;
    private GrigFeedNoticias grid;
    
    
    public ControlFeedNoticias() {
        jdFeed = new JDFeedNoticias(null, true);   
        grid = new GrigFeedNoticias();
        noticia = new Noticia();
        noticiaDao = new br.udesc.notifymenow.reader.model.dao.sqlite.NoticiaDao();
        inicializaComponentes();
    }
    
    public void inicializaComponentes(){
        jdFeed.tbNoticias.setModel(grid);
        carregarNoticias();
        jdFeed.btCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               check();
            }
        });
        
        
    }
    public void check(){
        
    RssReader reader = RssReaderFactory.getRssReader();
     for (Site site : siteDao.lista()) {
        for (Noticia noticia : reader.retrieve(site.getLink())) {
          grid.addNoticia(noticia);
          gravar(noticia);
  
        }
        }
    
    }
    public void gravar(Noticia noticia){
        noticiaDao.salva(noticia);
        Logger.info("noticia inserida");
        
    }
    public void carregarNoticias(){
        grid.limpar();
          for (Noticia noticia : noticiaDao.lista()) {
            grid.addNoticia(noticia);      
    }
    }
    public void executar(){

        jdFeed.setVisible(true);
    }
}
