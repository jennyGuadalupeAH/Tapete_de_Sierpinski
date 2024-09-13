/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tapete_desierpinski;

/**
 *
 * @author jenny
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tapete_deSierpinski extends JPanel {

    
    private final int initialSize = 400;
    private final int border = 20;

   
    private final String title = "Tapete de Sierpinski";

    public Tapete_deSierpinski() {
      
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint(); 
            }
        });
    }



    public static void main(String[] args) {
      
        JFrame frame = new JFrame("Tapete de Sierpinski");
        Tapete_deSierpinski panel = new Tapete_deSierpinski();

    
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 500); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
