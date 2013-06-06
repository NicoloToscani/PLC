/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pokus
 */
public class PLCCore implements Runnable{

    @Override
    public void run() {
        while(true){
            System.out.println("Cool");
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(PLCCore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
