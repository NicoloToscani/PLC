/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author pokus
 */
public class BackgroundPanel extends JPanel {

    ArrayList<Rung> jp = new ArrayList<>();
    ToolsMenu tm = new ToolsMenu();
    static Rung active;
    public BackgroundPanel(Logger logger) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(230, 230,230));
        
        for (int i = 0; i < 10; i++) {
            JPanel panel = new Rung(this.getSize());            
            panel.addMouseListener(new RungMouseListener(panel, jp, tm));            
            jp.add((Rung)panel);
            this.add(panel);            
            this.add(Box.createVerticalStrut(5));
        }

        logger.info("BackgroundPanel done");
    }
}
