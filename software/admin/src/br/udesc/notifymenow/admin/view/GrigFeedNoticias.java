/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.view;

import br.udesc.notifymenow.reader.model.entity.Noticia;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wagner
 */
public class GrigFeedNoticias extends AbstractTableModel {

    private ArrayList<Noticia> noticias = new ArrayList<Noticia>();

    @Override
    public int getRowCount() {
        return noticias.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Noticia noticia = noticias.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return noticia.getTitulo();
            }
            case 1: {
                return noticia.getConteudo();
            }
            case 2: {
                return noticia.getData();
            }
            case 3: {
                return noticia.getLink();
            }

        }
        return null;

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: {
                return "Titulo";
            }
            case 1: {
                return "Conteúdo";
            }
            case 2: {
                return "Data";
            }
            case 3: {
                return "Link";
            }
        }
        return null;
    }

    public void limpar() {
        noticias.clear();
    }

    public void removeNoticia(int posicao) {
        noticias.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }

    public Noticia getNoticia(int posicao) {
        return noticias.get(posicao);
    }

    public void addNoticia(Noticia noticia) {
        noticias.add(noticia);
        fireTableRowsInserted(noticias.size() - 1, noticias.size() - 1);
    }
}
