/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.GrigFeedNoticias;
import br.udesc.notifymenow.admin.view.JDFeedNoticias;
import br.udesc.notifymenow.reader.model.Noticia;
import br.udesc.notifymenow.reader.model.dao.NoticiaDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Wagner
 */
public class ControlFeedNoticias {

    JDFeedNoticias jdFeed;
    Noticia noticia;
    GrigFeedNoticias grid;
    NoticiaDao noticiaDao;
    
    
    public ControlFeedNoticias() {
        jdFeed = new JDFeedNoticias(null, true);   
        grid = new GrigFeedNoticias();
        noticia = new Noticia();
        noticiaDao = new br.udesc.notifymenow.reader.model.dao.sqlite.NoticiaDao();
        inicializaComponentes();
    }
    
    public void inicializaComponentes(){
        jdFeed.tbNoticias.setModel(grid);
        jdFeed.btCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               check();
            }
        });
        
        
    }
    
    public void check(){}
    
    public void executar(){

        jdFeed.setVisible(true);
    }
}
