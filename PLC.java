/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.util.Locale;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author pokus
 */
public class PLC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final Logger LOGGER = Logger.getLogger(PLC.class.getName());
        final Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new SimpleFormatter());
        
        LOGGER.addHandler(consoleHandler);
        LOGGER.setLevel(Level.ALL);
        Locale locale = Locale.getDefault();
        LOGGER.log(Level.INFO, "Actual locale: {0}", locale);
        
        
        Window w = new Window(LOGGER, locale);
        w.setVisible(true);
        
        Thread t = new Thread(new PLCCore());
        //t.start();
    }
}
