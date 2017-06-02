/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.GridSite;
import br.udesc.notifymenow.admin.view.JDCadSite;
import br.udesc.notifymenow.admin.view.JFPrincipal;
import br.udesc.notifymenow.reader.model.entity.Site;
import br.udesc.notifymenow.reader.model.dao.SiteDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Wagner
 */
public class ControlCadSite {
    
    private JDCadSite jdCadSite;
    private Site site;
    private SiteDao siteDao;
    private GridSite grid;
    private ArrayList<Site> sites = new ArrayList<>();
  

    public ControlCadSite() {
        jdCadSite = new JDCadSite(null, true);
        site = new Site();
        grid = new GridSite();
        siteDao = new br.udesc.notifymenow.reader.model.dao.sqlite.SiteDao();
        iniciazaComponenter();
       
    }
    public void iniciazaComponenter(){
        jdCadSite.tbSites.setModel(grid);
        jdCadSite.btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               gravar();
            }
        });
        
        jdCadSite.btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               alterar();
            }
        });
        jdCadSite.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               excluir();
            }
        });
        jdCadSite.btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               limpar();
            }
        });
        
    }
    public void executar(){
        jdCadSite.setVisible(true);
    }
    
    public void gravar(){
        
    }
    
    public void alterar(){}
    public void excluir(){}
    
    public void limpar(){
         jdCadSite.tfNome.setText(null);
         jdCadSite.tfLink.setText(null);
    }
}
