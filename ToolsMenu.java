/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plc;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 *
 * @author pokus
 */
public class ToolsMenu extends JDialog{
    
    BackgroundPanel bp;
    public ToolsMenu(final BackgroundPanel bp){
        //this.setPreferredSize(new Dimension(500, 50));
        this.bp = bp;
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
            new JButton("-| ? |-"),
            new JButton("   +   ")
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
        
        for (int i = 0; i < 8; i++) {
            jp.add(buttons[i]);
            buttons[i].addActionListener(new ToolsMenuListener(a[i]));
        }
        jp.add(buttons[8]);
        buttons[8].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                bp.addRung();
            }
        });
        
        
        this.add(jp);
        this.pack();
    }
    
}
