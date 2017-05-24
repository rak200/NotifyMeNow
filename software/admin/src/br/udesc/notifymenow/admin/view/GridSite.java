/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.view;

import br.udesc.notifymenow.reader.model.Site;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wagner
 */
public class GridSite extends AbstractTableModel {

    private ArrayList<Site> sites = new ArrayList<Site>();
    
    @Override
    public int getRowCount() {
        return sites.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Site site = sites.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return site.getNome();
            }
            case 1: {
                return site.getLink();
            }
          
        }
        return null;
   
    }
    
     public void limpar() {
        sites.clear();
    }

    public void removeSite(int posicao) {
        sites.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }

    public Site getSite(int posicao) {
        return sites.get(posicao);
    }

    public void addSite(Site site) {
        sites.add(site);
        fireTableRowsInserted(sites.size() - 1, sites.size() - 1);
    }

}

