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
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import br.udesc.notifymenow.reader.util.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Wagner
 */
public class ControlCadSite {
    private SiteDao siteDao = DaoFactory.getSite();
    private JDCadSite jdCadSite;
    private Site siteAtual;
    private GridSite grid;
    private ArrayList<Site> sites = new ArrayList<>();
  

    public ControlCadSite() {
        jdCadSite = new JDCadSite(null, true);
        siteAtual=null;
        grid = new GridSite();
        iniciazaComponenter();
       
    }
    public void iniciazaComponenter(){
        jdCadSite.tbSites.setModel(grid);
        carregarSites();
        jdCadSite.btSalvar.addActionListener(new ActionListener() {
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
        
    }
    public void executar(){
        jdCadSite.setVisible(true);
    }
    
    public void gravar(){       
        Site site = new Site();
        if (siteAtual == null)  {        
        site.setNome(jdCadSite.tfNome.getText());
        site.setLink(jdCadSite.tfLink.getText());
        if (siteDao.salva(site)){           
        JOptionPane.showMessageDialog(jdCadSite, "Site inserido com sucesso");
        Logger.info("inserido");
        }
    }else{
            site.setNome(jdCadSite.tfNome.getText());
            site.setLink(jdCadSite.tfLink.getText());
            site.setId(siteAtual.getId());
           
            if (siteDao.altera(site)) {
                JOptionPane.showMessageDialog(jdCadSite, "Site editado com sucesso");
                limpar();
            } else {
                JOptionPane.showMessageDialog(jdCadSite, "Erro ao editar site");
            }
        }
        limpar();
        carregarSites();
    }
    public void alterar(){
    int posicao = jdCadSite.tbSites.getSelectedRow();
        if (posicao >= 0) {
            siteAtual = grid.getSite(posicao);
            jdCadSite.tfNome.setText(siteAtual.getNome());
            jdCadSite.tfLink.setText(siteAtual.getLink());
            siteAtual.getId();
            carregarSites();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um site");
        }
    
    }
    public void excluir(){      
    int posicao = jdCadSite.tbSites.getSelectedRow();
        if (posicao >= 0) {
            siteAtual = grid.getSite(posicao);
            if (siteDao.exclui(siteAtual)) {
                JOptionPane.showMessageDialog(null, "Site removido com sucesso");
                grid.removeSite(posicao);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover site");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um site");
        }
        limpar();
        carregarSites();
    
    }
    
    public void limpar(){
         jdCadSite.tfNome.setText(null);
         jdCadSite.tfLink.setText(null);
         siteAtual=null;
    }
    
    public void carregarSites(){
        grid.limpar();
          for (Site site : siteDao.lista()) {
            grid.addSite(site);
        }
    }
}
