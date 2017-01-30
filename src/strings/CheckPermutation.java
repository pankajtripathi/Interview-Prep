package com.datastructures.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/20/16.
 */
public class CheckPermutation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the string-1: ");
        String str1 = s.nextLine();

        System.out.println("Enter the string-2: ");
        String str2 = s.nextLine();

        // System.out.println(isPermutationSorting(str1, str2));
        // System.out.println(isPermutationDS(str1, str2));
        System.out.println(isPermutation(str1, str2));
    }

    /*
    * Keep count of each character in an array. if count is less than zero then return false.
    * */
    private static boolean isPermutation(String str1, String str2) {
        if(str1.length() == 0 && str2.length() == 0) return true;
        if(str1.length() == 0 || str2.length() == 0) return false;
        if(str1.length() != str2.length()) return false;
        int charCount[] = new int[256];

        for(char c: str1.toCharArray())
            charCount[c]++;

        for(char c: str2.toCharArray()){
            charCount[c]--;
            if(charCount[c] < 0) return false;
        }
        return true;
    }

    /*
    * Using sorting to check O(nlogn)
    * */
    private static boolean isPermutationSorting(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        Arrays.sort(str1.toCharArray());
        Arrays.sort(str2.toCharArray());

        if(String.valueOf(c1).equals(String.valueOf(c2)))
            return true;
        else return false;
    }
}
