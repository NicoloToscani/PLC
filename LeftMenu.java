/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author pokus
 */
public class LeftMenu extends JPanel{
    
    public LeftMenu(){
        this.setBackground(Color.WHITE);
        this.setSize(250, 130);
        this.setMinimumSize(new Dimension(300, 130));
        this.setMaximumSize(new Dimension(300, 130));
        this.setPreferredSize(new Dimension(300, 130));
    }
    
}
