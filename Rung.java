/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author pokus
 */
public class Rung extends JPanel {

    private JLabel rung;
    JTextField note;
    private static final int LEFT_SPACE = 20;
    private static final int TOP_SPACE = 35;
    private static final int LENGTH_BASE = 150;
    private static final int ACT_BORDER = 10;
    private boolean active;
    private ArrayList<Actions> program;
    

    public Rung(Dimension dimension) {
        this.setPreferredSize(new Dimension(750, 160));
        this.setBackground(new Color(245, 245, 245));
        this.rung = new JLabel("Rung");
        this.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
        this.note = new JTextField(60);
        this.add(rung);
        this.add(note);
        this.program = new ArrayList<>();
        this.revalidate();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int xlast = 0;
        Dimension panel = this.getSize();
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(3));
        g2.drawLine(LEFT_SPACE, TOP_SPACE, LEFT_SPACE, LENGTH_BASE);   //left base line
        g2.drawLine(panel.width - LEFT_SPACE, TOP_SPACE, panel.width - LEFT_SPACE, LENGTH_BASE);   //right base line

        if(program.isEmpty()){
            g2.drawLine(LEFT_SPACE, panel.height / 2 - 10, panel.width - 20, panel.height / 2 - 10);
        }

        if (active) {
            g2.setColor(Color.red);
            g2.fillRect(xlast + LEFT_SPACE + ACT_BORDER, panel.height / 2 - 25, 30, 30);
        }
        
        g2.setFont(new Font("Arial", Font.BOLD, 20));
        for (int i = 0; i < program.size(); i++) {
            switch(program.get(i)){
                case NOCONTACT:
                    g2.drawString("--| |--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case NCCONTACT:
                    g2.drawString("--|/|--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case RCONTACT:
                    g2.drawString("--|R|--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case FCONTACT:
                    g2.drawString("--|F|--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case NOCOIL:
                    g2.drawString("--( )--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case NCCOIL:
                    g2.drawString("--(/)--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case SCOIL:
                    g2.drawString("--(S)--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case RCOIL:
                    g2.drawString("--(R)--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
                case CMP:
                    g2.drawString("--| < |--", xlast+LEFT_SPACE, panel.height / 2 - 4);
                    break;
            }
            xlast += 50;
        }
        
        g2.drawLine(xlast + LEFT_SPACE, panel.height / 2 - 10, panel.width - 20, panel.height / 2 - 10);
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public void addAction(Actions a) throws Exception{
        if(!program.add(a)){
            throw new Exception("Cannot add action.");
        }
        this.repaint();
    }
    
    public void print(String msg){
        System.out.println(msg);
    }
}
