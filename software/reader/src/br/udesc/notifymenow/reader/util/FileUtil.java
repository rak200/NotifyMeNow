/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.reader.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ricardo Augusto Küstner
 */
public class FileUtil {

    public static String getContent(String file) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        try {
            reader = new BufferedReader(new FileReader(file));
            try {
                String line = reader.readLine();

                while (line != null) {
                    builder.append(line);
                    builder.append(System.lineSeparator());
                    line = reader.readLine();
                }
                String everything = builder.toString();
            } catch (IOException ex) {
                Logger.error(ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.error(ex);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                Logger.error(ex);
            }
        }

        return builder.toString();
    }
}
