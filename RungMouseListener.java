/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author pokus
 */
public class RungMouseListener implements MouseListener {

    private ToolsMenu tm;
    private ArrayList<Rung> jp;
    private JPanel panel;

    public RungMouseListener(JPanel panel, ArrayList<Rung> jp, ToolsMenu tm) {
        this.tm = tm;
        this.jp = jp;
        this.panel = panel;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (!tm.isVisible()) {
            tm.setVisible(true);
            tm.setAlwaysOnTop(true);
        }

        if (BackgroundPanel.active != null) {
            BackgroundPanel.active.setActive(false);
            BackgroundPanel.active.repaint();
        }

        tm.setLocationRelativeTo(((Rung)panel).note);
        ((Rung) panel).setActive(true);
        ((Rung) panel).repaint();
        BackgroundPanel.active = (Rung) panel;
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }
}
