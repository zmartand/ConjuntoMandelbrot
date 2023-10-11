package org.example;

import javax.swing.*;
import java.awt.*;

public class Principal {
    public void generarConjuntoMandelbrot(){
        int width = 800;
        int height = 600;
        int numProcesos = 4;
        Renderizador renderizador = new Renderizador(width,height);
        Color[][] image = renderizador.render(numProcesos);
        JFrame frame = new JFrame("Mandelbrot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Panel(image));
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
