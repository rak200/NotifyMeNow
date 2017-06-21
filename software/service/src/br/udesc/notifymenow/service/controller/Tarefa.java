/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.service.controller;

import br.udesc.notifymenow.reader.model.bo.NoticiaBo;
import br.udesc.notifymenow.reader.model.dao.sqlite.DaoFactory;
import java.util.TimerTask;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Tarefa extends TimerTask {

    @Override
    public void run() {
        NoticiaBo bo = new NoticiaBo(DaoFactory.getNoticia());
        bo.atualiza();
        bo.enviaEmail();
    }

}
