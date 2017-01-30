package com.practice.designpatterns.facade;

/**
 * Created by pankajtripathi on 10/16/16.
 */
public class ShapeType {
    private Shape circle;
    private Shape rectangle;

    public ShapeType(){
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }
}
