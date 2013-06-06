/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pokus
 */
public class ToolsMenuListener implements ActionListener{
    
    private Actions act;
    public ToolsMenuListener(Actions act){
        this.act = act;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BackgroundPanel.active.addAction(act);
        } catch (Exception ex) {
            Logger.getLogger(ToolsMenuListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
