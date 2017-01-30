    package com.practice.threads.producerconsumer;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;

    /**
     * Created by pankajtripathi on 10/16/16.
     */
    class App{
        private static final LowLevelProducerConsumer obj = new LowLevelProducerConsumer();

        public static void main(String[] args) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    obj.produce();
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    obj.consume();
                }
            });

            t1.start();
            t2.start();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.exit(0);
        }
    }

    public class LowLevelProducerConsumer {
        private List<Integer> list = new ArrayList<>();
        private final int LIMIT = 10;
        private Object lock = new Object();
        private Random random = new Random();

        public void produce(){
            int value = 0;

            synchronized (lock){
                while (true){
                    while (list.size() == LIMIT){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.add(value++);
                    lock.notify();
                }
            }
        }

        public void consume(){
            synchronized (lock){
                while (true){
                    System.out.print("List size: "+list.size());
                    while (list.size() == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int val = list.remove(0);
                    System.out.println(" ; Value added: "+val);
                    lock.notify();
                }
            }
        }

    }
