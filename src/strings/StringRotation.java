package com.datastructures.arraysandstrings;

import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/24/16.
 */
public class StringRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String-1: ");
        String str1 = scanner.nextLine();

        System.out.println("Enter the String-2: ");
        String str2 = scanner.nextLine();
        System.out.println(isRotation(str1, str2));
    }

    private static boolean isRotation(String str1, String str2) {
        if(str2.length() == str1.length() && str1.length() > 0){
            String join = str1 + str1;
            return join.contains(str2);
        }
        return false;
    }

}
