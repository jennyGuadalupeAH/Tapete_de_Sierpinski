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

    // Tamaño inicial del cuadrado y margen
    private final int initialSize = 400;
    private final int border = 20;

    // Título para mostrar en el panel
    private final String title = "Tapete de Sierpinski";

    public Tapete_deSierpinski() {
        // Configurar el panel para detectar clics del ratón
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                repaint(); // Redibuja el panel cuando se presiona el ratón
            }
        });
    }

  

    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Sierpinski Carpet");
        Tapete_deSierpinski panel = new Tapete_deSierpinski();

        // Configuración de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(500, 500); // Tamaño de la ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        frame.setVisible(true);
    }
}
