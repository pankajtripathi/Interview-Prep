package com.datastructures.arraysandstrings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/20/16.
 */
public class IsUnique {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = s.nextLine();
        System.out.println(isUnique(str));
    }

    /*
    * This is solution with time complexity  - O(n) space - O(1)
    * */
    private static boolean isUnique(String str) {
        boolean chars[] = new boolean[256];

        for(char c: str.toCharArray()){
            if(chars[c]) return false;
            chars[c] = true;
        }
        return true;
    }

    /*
    * This is solution with time complexity  - O(nlogn) space - O(1)
    * */
    private static boolean isUniqueSorting(String str) {
        if(str.length() == 0 || str.length() == 1) return true;
        int i=0, j=1;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        while(j < chars.length && i < chars.length){
            if(chars[i] == chars[j]) return false;
            i++;
            j++;
        }
        return true;
    }
}
