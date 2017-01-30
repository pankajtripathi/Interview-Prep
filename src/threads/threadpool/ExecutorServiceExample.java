package com.practice.threads.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by pankajtripathi on 10/15/16.
 */

class App implements Runnable{
    private int id;

    App(int id){
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Started: "+ id);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending: "+id);
    }
}
public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.submit(new App(i));
        }
        executor.shutdown();

        System.out.println("All tasks submitted.........");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed.........");

    }
}
