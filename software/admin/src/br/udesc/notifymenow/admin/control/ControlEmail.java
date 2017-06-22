/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.JDEmail;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Wagner
 */
public class ControlEmail {

    JDEmail jdEmail;

    public ControlEmail() {
        jdEmail = new JDEmail(null, true);
        inicializaComponentes();
    }

    public void executar() {
        jdEmail.setVisible(true);
    }

    public void inicializaComponentes() {
        jdEmail.btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });

        jdEmail.btCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
    }

    public void gravar() {
    }

    public void cancelar() {
        limpar();
        jdEmail.btCancelar.setEnabled(true);
        jdEmail.setVisible(false);
    }

    private void limpar() {
        jdEmail.tfEmail.setText(null);

    }

}
