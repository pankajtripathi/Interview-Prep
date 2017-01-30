package com.practice.designpatterns.factory;

/**
 * Created by pankajtripathi on 10/16/16.
 */
public class FactoryPattern {
    public static void main(String[] args) {
        ShapeType st = new ShapeType();

        Shape c = st.getShapeType("Circle");
        c.draw();

        Shape r = st.getShapeType("Rectangle");
        r.draw();
    }
}
