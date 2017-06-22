/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.view;

import br.udesc.notifymenow.reader.model.entity.Assunto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Wagner
 */
public class GridAssunto extends AbstractTableModel {

    private ArrayList<Assunto> assuntos = new ArrayList<Assunto>();

    @Override
    public int getRowCount() {
        return assuntos.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Assunto assunto = assuntos.get(rowIndex);
        switch (columnIndex) {
            case 0: {
                return assunto.getNome();
            }

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: {
                return "Nome";
            }
        }
        return null;
    }

    public void limpar() {
        assuntos.clear();
    }

    public void removeAssunto(int posicao) {
        assuntos.remove(posicao);
        fireTableRowsDeleted(posicao, posicao);
    }

    public Assunto getAssunto(int posicao) {
        return assuntos.get(posicao);
    }

    public void addAssunto(Assunto assunto) {
        assuntos.add(assunto);
        fireTableRowsInserted(assuntos.size() - 1, assuntos.size() - 1);
    }

}
