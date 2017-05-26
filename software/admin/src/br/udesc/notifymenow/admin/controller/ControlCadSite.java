/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.JDCadSite;
import br.udesc.notifymenow.admin.view.JFPrincipal;
import br.udesc.notifymenow.reader.model.Site;
import br.udesc.notifymenow.reader.model.dao.SiteDao;
import java.util.ArrayList;

/**
 *
 * @author Wagner
 */
public class ControlCadSite {
    
    private JDCadSite cadSite;
    private Site site;
    private SiteDao siteDao;
    private ArrayList<Site> sites = new ArrayList<>();
  

    public ControlCadSite() {
        cadSite = new JDCadSite(null, true);
        site = new Site();
        siteDao = new br.udesc.notifymenow.reader.model.dao.sqlite.SiteDao();
       
    }
    
    public void executar(){
        cadSite.setVisible(true);
    }
}
