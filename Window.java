/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.util.Locale;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author pokus
 */
public class Window extends JFrame{

    public Window(Logger logger, Locale locale) {
        this.setLayout(new BorderLayout());
        this.add(new TopMenu(logger, locale), BorderLayout.PAGE_START);
        JScrollPane sp = new JScrollPane(new BackgroundPanel(logger));
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp.getVerticalScrollBar().setUnitIncrement(20);
        this.add(sp, BorderLayout.CENTER);
        this.add(new LeftMenu(), BorderLayout.WEST);
        this.setSize(500, 500);
        this.setVisible(true);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        System.out.println("init: " + Runtime.getRuntime().totalMemory());
    }
}
