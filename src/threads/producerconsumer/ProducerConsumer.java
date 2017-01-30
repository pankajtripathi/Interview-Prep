package com.practice.threads.producerconsumer;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by pankajtripathi on 10/16/16.
 */
public class ProducerConsumer {
    private static BlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(10);
    private static Random random = new Random();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                producer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                consumer();
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
    }

    private static void producer(){
        while(true) {
            try {
                q.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer(){
        while (true) {
            try {
                Thread.sleep(100);
                if (random.nextInt(10) == 0) {
                    Integer val = q.take();
                    System.out.println("Values: " + val + " Queue size: " + q.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
