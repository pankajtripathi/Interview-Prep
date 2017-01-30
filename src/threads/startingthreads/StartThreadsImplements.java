package com.practice.threads.startingthreads;

/**
 * Created by pankajtripathi on 10/15/16.
 */
class App implements Runnable{
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
}
public class StartThreadsImplements {
    public static void main(String[] args) {
        Thread t1 = new Thread(new App());
        Thread t2 = new Thread(new App());
        t1.start();
        t2.start();
    }
}
