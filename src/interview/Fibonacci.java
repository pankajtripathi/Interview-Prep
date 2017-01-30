package com.practice.interview;

import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/17/16.
 */
public class Fibonacci {
    static int n1 = 0, n2 = 1, n3;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = s.nextInt();
        printFibonacci(num);

        System.out.println();
        System.out.print(0 + " " + 1);
        printFibonacciRec(num-2);

    }

    private static void printFibonacciRec(int num) {
        if(num > 0){
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(" "+n3);
            printFibonacciRec(--num);
        }
    }

    private static void printFibonacci(int num) {
        int n1 = 0, n2 = 1, n3 = 0;
        System.out.print(n1 + " " + n2);
        for(int i=2; i<num; i++){
            n3 = n1 + n2;
            System.out.print(" " + n3);
            n1 = n2;
            n2 = n3;
        }
    }
}
