package com.practice.designpatterns.singleton;

/**
 * Created by pankajtripathi on 10/16/16.
 */

class SingleObject{
    private final static SingleObject instance = new SingleObject();
    private SingleObject(){}

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("Singleton Demo..........");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        SingleObject ins = SingleObject.getInstance();
        ins.showMessage();
    }
}

