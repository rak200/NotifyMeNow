/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.GridAssunto;
import br.udesc.notifymenow.admin.view.GridAssunto;
import br.udesc.notifymenow.admin.view.JDCadAssunto;
import br.udesc.notifymenow.reader.model.entity.Assunto;
import br.udesc.notifymenow.reader.model.dao.AssuntoDao;
import br.udesc.notifymenow.reader.model.dao.AssuntoDao;
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import br.udesc.notifymenow.reader.model.entity.Assunto;
import br.udesc.notifymenow.reader.util.Logger;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Wagner
 */
public class ControlCadAssunto {
    private AssuntoDao assuntoDao = DaoFactory.getAssunto();
    private JDCadAssunto jdCadAssunto;
    private GridAssunto grid;
    private Assunto assuntoAtual;

    public ControlCadAssunto() {
        jdCadAssunto = new JDCadAssunto(null, true);
        grid = new GridAssunto();
        assuntoAtual=null;
        inicializaComponentes();
    }
    private void inicializaComponentes() {
        jdCadAssunto.tbDescricao.setModel(grid);
        carregarAssuntos();
        jdCadAssunto.btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               gravar();
            }
        });
        
        jdCadAssunto.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alterar();
            }
        });
         jdCadAssunto.btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                excluir();
            }
        });
         
         
        

    }
    public void executar(){
        jdCadAssunto.setVisible(true);
    }
    
 public void gravar(){       
        Assunto assunto = new Assunto();
        if (assuntoAtual == null)  {        
        assunto.setNome(jdCadAssunto.tfAssunto.getText());
        if (assuntoDao.salva(assunto)){           
        JOptionPane.showMessageDialog(jdCadAssunto, "Assunto inserido com sucesso");
        Logger.info("inserido");
        }
    }else{
            assunto.setNome(jdCadAssunto.tfAssunto.getText());
            assunto.setId(assuntoAtual.getId());
           
            if (assuntoDao.altera(assunto)) {
                JOptionPane.showMessageDialog(jdCadAssunto, "Assunto editado com sucesso");
                limpar();
            } else {
                JOptionPane.showMessageDialog(jdCadAssunto, "Erro ao editar assunto");
            }
        }
        limpar();
        carregarAssuntos();
    }
    public void alterar(){
    int posicao = jdCadAssunto.tbDescricao.getSelectedRow();
        if (posicao >= 0) {
            assuntoAtual = grid.getAssunto(posicao);
            jdCadAssunto.tfAssunto.setText(assuntoAtual.getNome());
            assuntoAtual.getId();
            carregarAssuntos();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um assunto");
        }
    
    }
    public void excluir(){      
    int posicao = jdCadAssunto.tbDescricao.getSelectedRow();
        if (posicao >= 0) {
            assuntoAtual = grid.getAssunto(posicao);
            if (assuntoDao.exclui(assuntoAtual)) {
                JOptionPane.showMessageDialog(null, "Assunto removido com sucesso");
                grid.removeAssunto(posicao);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao remover assunto");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um assunto");
        }
        limpar();
        carregarAssuntos();
    
    }
    
    public void limpar(){
         jdCadAssunto.tfAssunto.setText(null);
         assuntoAtual=null;
    }
    
    public void carregarAssuntos(){
        grid.limpar();
          for (Assunto assunto : assuntoDao.lista()) {
            grid.addAssunto(assunto);
   
    
}
    }
}
