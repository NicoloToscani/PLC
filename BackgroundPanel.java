/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author pokus
 */
public class BackgroundPanel extends JPanel {

    ArrayList<Rung> jp = new ArrayList<>();
    ToolsMenu tm = new ToolsMenu(this);
    static Rung active;

    public BackgroundPanel(Logger logger) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(230, 230, 230));

        for (int i = 0; i < 1; i++) {
            JPanel panel = new Rung(this.getSize());
            panel.addMouseListener(new RungMouseListener(panel, jp, tm));
            jp.add((Rung) panel);
            this.add(panel);
            this.add(Box.createVerticalStrut(5));
        }

        logger.info("BackgroundPanel done");
    }

    public void addRung() {
        JPanel panel = new Rung(this.getSize());
        panel.addMouseListener(new RungMouseListener(panel, jp, tm));
        jp.add((Rung) panel);
        this.add(panel);
        this.add(Box.createVerticalStrut(5));
        panel.revalidate();
        this.revalidate();
    }
}
