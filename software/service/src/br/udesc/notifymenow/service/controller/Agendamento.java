/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.service.controller;

import br.udesc.notifymenow.reader.util.Property;
import java.util.Timer;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Agendamento extends Timer {

    public void iniciar() {
        schedule(new Tarefa(), 1000, getIntervalo());
    }

    private long getIntervalo() {
        String intervalo = Property.get("intervalo_verificacao");
        // horas convertido em milisegundos
        return Long.parseLong(intervalo) * 1000 * 60 * 60;
    }

}
