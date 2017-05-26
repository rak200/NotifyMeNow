/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.JDHorario;

/**
 *
 * @author Wagner
 */
public class ControlHorario {
    
    JDHorario horario;
    
    public ControlHorario(){
      horario = new JDHorario(null, true);  
    }
    
    public void executar(){
      
      horario.setVisible(true);  
    }
    
}
