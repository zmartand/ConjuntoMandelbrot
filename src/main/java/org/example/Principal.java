package org.example;

import javax.swing.*;
import java.awt.*;

public class Principal {
    public void generarConjuntoMandelbrot(){
        int width = 800;
        int height = 600;

        //Pregunta al usuario cuántos procesos desea utilizar.
        String input = JOptionPane.showInputDialog("Ingrese el número de procesos:");
        int numProcesos = Integer.parseInt(input);
        Renderizador renderizador = new Renderizador(width, height);
        Color[][] image = renderizador.render(numProcesos);
        JFrame frame = new JFrame("Conjunto de Mandelbrot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.add(new Panel(image));
        frame.setVisible(true);
    }
}
