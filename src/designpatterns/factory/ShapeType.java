package com.practice.designpatterns.factory;

/**
 * Created by pankajtripathi on 10/16/16.
 */
public class ShapeType {
    public Shape getShapeType(String type){

        if(type == null) return null;

        else if (type.equalsIgnoreCase("Circle")) return new Circle();

        else if (type.equalsIgnoreCase("Rectangle")) return new Rectangle();

        else return null;
    }
}
