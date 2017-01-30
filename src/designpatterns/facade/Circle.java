package com.practice.designpatterns.facade;

/**
 * Created by pankajtripathi on 10/16/16.
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::Draw");
    }
}
