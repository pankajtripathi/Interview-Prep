package com.practice.designpatterns.facade;

/**
 * Created by pankajtripathi on 10/16/16.
 */
public class FacadePattern {
    public static void main(String[] args) {
        ShapeType st = new ShapeType();
        st.drawCircle();
        st.drawRectangle();
    }
}
