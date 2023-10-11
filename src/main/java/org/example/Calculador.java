package org.example;

import java.awt.*;

public class Calculador implements Callable<List<Color>>{
    private final int startY, endY, width, height, maxIterations;

    public Calculador(int startY, int endY, int width, int height, int maxIterations) {
        this.startY = startY;
        this.endY = endY;
        this.width = width;
        this.height = height;
        this.maxIterations = maxIterations;
    }
    

}
