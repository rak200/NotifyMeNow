/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util;

import br.udesc.notifymenow.reader.Main;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class LogConfig {

    public static void defineLogger() {
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger("Reader");
        FileHandler arquivo;

        try {
            arquivo = new FileHandler("log/log%u.txt");
            logger.addHandler(arquivo);
            logger.setLevel(Level.ALL);
            arquivo.setFormatter(new SimpleFormatter());
        } catch (IOException | SecurityException ex) {
            java.util.logging.Logger.getLogger("Reader").log(Level.SEVERE, null, ex);
        }
    }
}
