/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.control;

import br.udesc.notifymenow.admin.view.JFPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Wagner
 */
public class ControlPrincipal {
    private JFPrincipal fPrincipal;
    private ControlCadSite cadSite;
    private ControlFeedNoticias cFeed;
    private ControlHorario cHorario;
    private ControlEmail cEmail;
    private ControlCadAssunto cAssunto;

    public ControlPrincipal() {
        fPrincipal = new JFPrincipal();
        cadSite = new ControlCadSite();
        cFeed = new ControlFeedNoticias();
        cHorario = new ControlHorario();
        cEmail = new ControlEmail();
        cAssunto = new ControlCadAssunto();
        inicializaComponentes();
    }

    private void inicializaComponentes() {
        fPrincipal.mFeedNoticias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                feedNoticia();
            }
        });
        fPrincipal.mCadSite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarSite();
            }
        });
        fPrincipal.mCadAssunto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarAssunto();
            }
        });

        fPrincipal.mHorario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarHorario();
            }
        });

//          fPrincipal.mEmail.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                cadastrarEmail();
//            }
//        }); 
    }

    private void cadastrarSite() {
        cadSite.executar();
    }

    private void feedNoticia() {
        cFeed.executar();
    }

    private void cadastrarHorario() {
        cHorario.executar();
    }

    private void cadastrarAssunto() {
        cAssunto.executar();
    }

    private void cadastrarEmail() {
        cEmail.executar();
    }

    public void executar() {
        fPrincipal.setVisible(true);
    }
}
