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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Limpiar el panel
        setBackground(Color.WHITE); 

        Graphics2D g2d = (Graphics2D) g;

        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

   
        drawCarpet(g2d, border, border, initialSize, 0);

        
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        
        
        FontMetrics metrics = g2d.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(title)) / 2;
        int y = metrics.getAscent();

       
        g2d.drawString(title, x, y);
    }

   
    private void drawCarpet(Graphics2D g, int x, int y, int size, int depth) {
       
        g.setColor(gradientColor(new Color(0, 191, 255), new Color(255, 99, 71), depth / 6.0f));

        
        g.fillRect(x, y, size, size);

        
        if (size > 10) {
            int newSize = size / 3;

            //
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    // Evitar el cuadrado central
                    if (row == 1 && col == 1) {
                        g.setColor(Color.WHITE);
                        g.fillRect(x + newSize, y + newSize, newSize, newSize); 
                    } else {
                        drawCarpet(g, x + row * newSize, y + col * newSize, newSize, depth + 1);
                    }
                }
            }
        }
    }

    // Método para interpolar entre dos colores
    private Color gradientColor(Color startColor, Color endColor, float ratio) {
        int red = (int) (startColor.getRed() * (1 - ratio) + endColor.getRed() * ratio);
        int green = (int) (startColor.getGreen() * (1 - ratio) + endColor.getGreen() * ratio);
        int blue = (int) (startColor.getBlue() * (1 - ratio) + endColor.getBlue() * ratio);
        return new Color(red, green, blue);
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
