/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.JDFeedNoticias;


/**
 *
 * @author Wagner
 */
public class ControlFeedNoticias {

    JDFeedNoticias feed;
    
    
    public ControlFeedNoticias() {
        feed = new JDFeedNoticias(null, true);      
    }
    
    public void executar(){

        feed.setVisible(true);
    }
}