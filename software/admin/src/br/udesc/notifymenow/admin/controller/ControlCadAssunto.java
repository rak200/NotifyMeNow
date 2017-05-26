/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.GridAssunto;
import br.udesc.notifymenow.admin.view.GridSite;
import br.udesc.notifymenow.admin.view.JDCadAssunto;
import br.udesc.notifymenow.reader.model.Assunto;
import br.udesc.notifymenow.reader.model.dao.AssuntoDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Wagner
 */
public class ControlCadAssunto {
    private JDCadAssunto cadAssunto;
    private GridAssunto grid;
    private Assunto assunto;
    private AssuntoDao assuntoDao;
    private ArrayList<Assunto> assuntos = new ArrayList<>();

    public ControlCadAssunto() {
        cadAssunto = new JDCadAssunto(null, true);
        grid = new GridAssunto();
        assuntoDao = new br.udesc.notifymenow.reader.model.dao.sqlite.AssuntoDao();
        inicializaComponentes();
    }
    private void inicializaComponentes() {
        cadAssunto.tbDescricao.setModel(grid);
        cadAssunto.btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               gravar();
            }
        });
        
        cadAssunto.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterar();
            }
        });
         cadAssunto.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
         
         cadAssunto.btPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });
        

    }
    public void executar(){
        cadAssunto.setVisible(true);
    }
    
    public void gravar(){
        
    }
    
    public void alterar(){
        
    }
    
    public void pesquisar(){
        
    }
    
    public void excluir(){
        
    }
    
}
