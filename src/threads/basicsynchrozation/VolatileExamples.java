package com.practice.threads.basicsynchrozation;

import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/15/16.
 */
class App extends Thread{
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutDown(){
        running = false;
    }
}

public class VolatileExamples {
    public static void main(String[] args) {

        App obj = new App();
        obj.start();

        Scanner s = new Scanner(System.in);
        s.nextLine();

        obj.shutDown();
    }
}
