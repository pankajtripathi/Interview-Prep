package com.practice.designpatterns.obeserver;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/16/16.
 */
class EventSource extends Observable implements Runnable{
    @Override
    public void run() {
        Scanner s = new Scanner(System.in);
        String response = s.nextLine();
        setChanged();
        notifyObservers(response);
    }
}


public class ObserverPattern{
    public static void main(String[] args) {
        EventSource es = new EventSource();
        System.out.println("Enter Text: ");
        es.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("Update recieved: " + arg);
            }
        });
        new Thread(es).start();
    }
}

