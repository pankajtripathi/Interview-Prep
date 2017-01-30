package com.practice.threads.startingthreads;

/**
 * Created by pankajtripathi on 10/15/16.
 */
public class StartThreadDiff{
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread " + i);
                }
            }
        });
        t1.start();
    }
}
