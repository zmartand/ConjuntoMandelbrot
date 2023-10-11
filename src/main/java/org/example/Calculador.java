package org.example;

import java.awt.*;
import java.util.ArrayList;

public class Calculador implements Callable<List<Color>>{
    private final int startY, endY, width, height, maxIterations;

    public Calculador(int startY, int endY, int width, int height, int maxIterations) {
        this.startY = startY;
        this.endY = endY;
        this.width = width;
        this.height = height;
        this.maxIterations = maxIterations;
    }
    //call
    @Override
public List<Color> call() throws Exception {
        List<Color> colors = new ArrayList<>();
        for (int y = startY; y < endY; y++) {
            for (int x = 0; x < width; x++) {
                double zx, zy, cX, cY, tmp;
                zx = zy = 0;
                cX = (x - width / 2.0) * 4.0 / width;
                cY = (y - height / 2.0) * 4.0 / height;
                int iter = 0;
                while (zx * zx + zy * zy < 4 && iter < maxIterations - 1) {
                    tmp = zx * zx - zy * zy + cX;
                    zy = 2.0 * zx * zy + cY;
                    zx = tmp;
                    iter++;
                }
                //Paleta de colores predefinida
                Color color = getColorForIteration(iter);
                colors.add(color);
            }
        }
        return colors;
    }
    //Función para asignar colores basados en el número de iteraciones
    private Color getColorForIteration(int iteration) {
        if (iteration == maxIterations - 1) {
            return Color.BLACK;
        } else {
            float hue = (float) iteration / maxIterations; // Utiliza el valor de iteración para el matiz
            return Color.getHSBColor(hue, 0.8f, 1.0f); // Saturación y brillo fijados para obtener colores vivos
        }
    }



}
