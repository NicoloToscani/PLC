/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NameAlreadyBoundException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author pokus
 */
public class ToolsMenu extends JDialog{
    
    public ToolsMenu(){
        //this.setPreferredSize(new Dimension(500, 50));
        this.setBackground(Color.BLUE);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        JButton buttons[] = new JButton[]{
            new JButton("--| |--"),
            new JButton("--|/|--"),
            new JButton("--( )--"),
            new JButton("--(/)--"),
            new JButton("--(S)--"),
            new JButton("--(R)--"),
            new JButton("-| < |-"),
            new JButton("-| ? |-")
        };
        
        Actions a[] = new Actions[]{
            Actions.NOCONTACT,
            Actions.NCCONTACT,
            Actions.NOCOIL,
            Actions.NCCOIL,
            Actions.SCOIL,
            Actions.RCOIL,
            Actions.CMP,
            Actions.EXECUTE
        };
        
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());
        
        for (int i = 0; i < buttons.length; i++) {
            jp.add(buttons[i]);
            buttons[i].addActionListener(new ToolsMenuListener(a[i]));
        }
        
        
        this.add(jp);
        this.pack();
    }
    
}
