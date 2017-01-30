package com.datastructures.arraysandstrings;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/21/16.
 */
public class PalindromePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = scanner.nextLine();
        System.out.println(isPalindromePermutation(str));
    }

    private static boolean isPalindromePermutation(String str) {
        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();

        // Permutation usage => permutation(char arr[], int left, int right)
        GeneratePermutation.permutation(str.toCharArray(), 0, str.length()-1);
        ArrayList<String> res = GeneratePermutation.res;
        if(res.contains(rev.toString())) return true;
        return false;
    }
}
