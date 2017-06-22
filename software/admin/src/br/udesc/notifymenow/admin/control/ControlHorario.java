/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.JDHorario;
import br.udesc.notifymenow.reader.util.Logger;
import br.udesc.notifymenow.reader.util.Property;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Wagner
 */
public class ControlHorario {

    JDHorario jdHorario;

    public ControlHorario() {
        jdHorario = new JDHorario(null, true);
        inicializaComponentes();
    }

    public void executar() {
        jdHorario.setVisible(true);
    }

    public void inicializaComponentes() {
        jdHorario.btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gravar();
            }
        });

    }

    public void gravar() {
        Property prop = null;
        String chave = "intervalo_verificacao";
        prop.set(chave, jdHorario.tfHorario.getText());
        JOptionPane.showMessageDialog(jdHorario, "Verificação estabelecida para o intervalo de " + jdHorario.tfHorario.getText() + " horas");
        Logger.info("inserido horario");
        limpar();
    }

    public void cancelar() {
        limpar();
        jdHorario.tfHorario.setText(null);
    }

    private void limpar() {
        jdHorario.tfHorario.setText(null);
    }

}
