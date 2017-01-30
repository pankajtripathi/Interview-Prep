package com.practice.threads.startingthreads;

/**
 * Created by pankajtripathi on 10/15/16.
 */
class Runner extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread "+ i);
        }
    }
}
public class StartThreadsExtends {
    public static void main(String[] args) {
        Runner obj1 = new Runner();
        Runner obj2 = new Runner();
        obj1.start();
        obj2.start();
    }
}
