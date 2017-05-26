/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.JDHorario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Wagner
 */
public class ControlHorario {
    
    JDHorario jdHorario;
    
    public ControlHorario(){
      jdHorario = new JDHorario(null, true);  
      inicializaComponentes();
    }
    
    public void executar(){
     
      jdHorario.setVisible(true);  
      
    }
    
    public void inicializaComponentes(){
        jdHorario.btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               gravar();
            }
        });
        
         jdHorario.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cancelar();
            }
        });
    }
    
    public void gravar(){}
    
    public void cancelar(){
        limpar();
        jdHorario.btCancelar.setEnabled(true);
        jdHorario.setVisible(false);
    }
    
     private void limpar() {
         jdHorario.tfHorario.setText(null);
        
    }
    
}
