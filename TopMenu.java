/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author pokus
 */
public class TopMenu extends JMenuBar{
    
    public TopMenu(Logger logger, Locale locale){
        ResourceBundle rb = ResourceBundle.getBundle("plc.PLC", locale);
        JMenu fileMenu = new JMenu(rb.getString("FILE"));
        fileMenu.setMnemonic(rb.getString("FILE_M").charAt(0));
        fileMenu.add(new JMenuItem(rb.getString("SAVE"), rb.getString("SAVE_M").charAt(0)));
        fileMenu.add(new JMenuItem(rb.getString("OPEN"), rb.getString("OPEN_M").charAt(0)));
        fileMenu.add(new JMenuItem(rb.getString("RECENT"), rb.getString("RECENT_M").charAt(0)));
        
        JMenu editMenu = new JMenu(rb.getString("EDIT"));
        editMenu.setMnemonic(rb.getString("EDIT_M").charAt(0));
        editMenu.add(new JMenuItem(rb.getString("FIND"), rb.getString("FIND_M").charAt(0)));
        
        this.add(fileMenu);
        this.add(editMenu);
    }
}
