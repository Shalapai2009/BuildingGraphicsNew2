package com.example.buildinggraphicsnew;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Rasterization {

    public static void drawLine(
            final GraphicsContext graphicsContext,String str,
            final Color color){
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        ArrayList<int[]> list= new ArrayList<>();
        int startX = 300;
        int startY = 300;
        for (int i = 0; i < 600; i+=1) {
            int y11 = Integer.parseInt(str)*(-1)+300;
            if (y11>-600){
                list.add(new int[]{i,y11});
            }
            if (y11>600){
                break;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            pixelWriter.setColor(list.get(i)[0],list.get(i)[1],color);
            if ((i!=0)){
                if ((list.get(i-1)[0]-list.get(i)[0])>1){

                    for (int j = list.get(i)[0]; j < list.get(i-1)[0]; j++) {
                        pixelWriter.setColor(j,list.get(i)[1],color);
                    }
                } else if ((list.get(i)[0]-list.get(i-1)[0])>1){
                    for (int j =list.get(i-1)[0]; j <  list.get(i)[0]; j++) {
                        pixelWriter.setColor(j,list.get(i)[1],color);
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            pixelWriter.setColor(list.get(i)[0],list.get(i)[1],color);
            if ((i!=0)){
                if ((list.get(i-1)[1]-list.get(i)[1])>1){

                    for (int j = list.get(i)[1]; j < list.get(i-1)[1]; j++) {
                        pixelWriter.setColor(list.get(i)[0],j,color);
                    }
                } else if ((list.get(i)[1]-list.get(i-1)[1])>1){
                    for (int j =list.get(i-1)[1]; j <  list.get(i)[1]; j++) {
                        pixelWriter.setColor(list.get(i)[0],j,color);
                    }
                }
            }
        }
        }
    }

