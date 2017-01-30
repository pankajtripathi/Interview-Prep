package com.practice.threads.basicsynchrozation;

/**
 * Created by pankajtripathi on 10/15/16.
 */
public class SynchronizedExamples {
    private int count = 0;

    private synchronized void increment(){
        count++;
    }

    public static void main(String[] args) {
        SynchronizedExamples obj = new SynchronizedExamples();
        obj.app();
    }

    private void app(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count "+ count);
    }
}
