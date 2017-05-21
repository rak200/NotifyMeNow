/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class Property {

    private static Properties properties;

    static {
        FileInputStream fileInput = null;
        try {
            File file = new File("config.properties");
            fileInput = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInput);
            fileInput.close();
        } catch (FileNotFoundException ex) {
            Logger.error(ex);
        } catch (IOException ex) {
            Logger.error(ex);
        } finally {
            try {
                fileInput.close();
            } catch (IOException ex) {
                Logger.error(ex);
            }
        }
    }

    public static String get(String chave) {
        return properties.getProperty(chave);
    }

}
