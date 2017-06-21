/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.service;

import br.udesc.notifymenow.reader.util.Property;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Main {

    public static void main(String[] args) {

        TimerTask task = new RunMeTask();

    	Timer timer = new Timer();
//    	timer.schedule(task, 1000,5000);

        System.out.println(Property.get("intervalo_verificacao"));
    }
}

class RunMeTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Run Me ~");
    }
}
