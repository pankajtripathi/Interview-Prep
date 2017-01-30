package com.datastructures.arraysandstrings;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/23/16.
 */
public class OneAway {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String str1 = scanner.nextLine();
        System.out.println("Enter the second string: ");
        String str2 = scanner.nextLine();
        //System.out.println(isOneAwayHashed(str1, str2));
        System.out.println(isOneAway(str1, str2));
    }

    /**
    * Second and optimal method.
    * */
    private static boolean isOneAway(String str1, String str2){
        if(str1.length() == str2.length())
            return needsReplacement(str1, str2);
        else if(str1.length() + 1 == str2.length())
            return needsInsertion(str1, str2);
        else if(str1.length() - 1 == str2.length())
            return needsInsertion(str1, str2);
        else return false;

    }

    /**
    * Helper methods for isOneAway method
    * 1. needsReplacement: if both are unqual and flag is true this means that this is second time that chracters
    *    are not equal so return false else make flag true and move ahead.
    * */
    private static boolean needsReplacement(String str1, String str2) {
        boolean flag = false;
        for (int i = 0; i < str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)){
                if(flag) return false;
            }
            flag = true;
        }
        return true;
    }

    /**
     * if both are equal then move both indexes else move the first index;
     * later check the diff between these indexes if that is greater than 1 then return false else true.
     */
    private static boolean needsInsertion(String str1, String str2) {
        int index1 = 0, index2 = 0;
        while(index1 < str1.length() && index2 < str2.length()){
            if(str1.charAt(index1) != str2.charAt(index2))
                index1++;
            else{
                index1++;
                index2++;
            }
        }
        return index1 - index2 > 1 ? false: true;
    }
}
