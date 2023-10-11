package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Renderizador {
    private final int width,height;
    private final int maxIterations = 1000;

    public Renderizador(int width,int height){
        this.width = width;
        this.height = height;
    }
    public Color[][] render(int numProcesos){
        ExecutorService executorService = Executors.newFixedThreadPool(numProcesos);
        int segmentHeight = height / numProcesos;
        List<Future<List<Color>>> futures = new ArrayList<>();

        for (int i = 0;i < numProcesos;i++){
            int startY = i * segmentHeight;
            int endY = (i + 1) * segmentHeight;
            Callable<List<Color>> task = new Calculador(startY,endY,width,height,maxIterations);
            Future<List<Color>> future = executorService.submit(task);
            futures.add(future);
        }
        Color[][] image = new Color[width][height];
        for (int i=0; i<numProcesos; i++) {
            try {
                List<Color> segmentColors = futures.get(i).get();
                for (int y = i * segmentHeight; y < (i + 1) * segmentHeight; y++) {
                    for (int x = 0; x < width; x++) {
                        image[x][y] = segmentColors.get((y - i * segmentHeight) * width + x);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return image;
    }
}
