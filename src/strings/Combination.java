package com.datastructures.arraysandstrings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/21/16.
 */
public class Combination {
    public static StringBuilder output = new StringBuilder();
    public static String inputString = "";
    public static int a[] = {1, 2, 3};
    public static List<Integer> out = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter the String: ");
        //inputString = scanner.nextLine();
        for(int i: a) inputString += i;
        System.out.println(inputString);
        combination(0);
        for(Integer i: out)
            System.out.print(i+ " ");
        System.out.println();
        System.out.println(Character.getNumericValue('2') + 10);
    }

    private static void combination(int start) {
        for (int i = start; i < inputString.length(); i++) {
            output.append(inputString.charAt(i));
            out.add(Integer.valueOf(output.toString()));
            if(i < inputString.length())
                combination(i+1);
            output.setLength(output.length()-1);
        }
    }
}
