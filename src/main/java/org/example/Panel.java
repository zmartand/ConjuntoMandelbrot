package org.example;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private final Color[][] image;
    public Panel(Color[][] image) {
        this.image = image;
    }
    //Método que pinta una matriz de colores en un panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                g.setColor(image[x][y]);
                g.drawLine(x, y, x, y);
            }
        }
    }
}
