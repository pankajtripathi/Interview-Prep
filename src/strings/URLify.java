package com.datastructures.arraysandstrings;

import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/20/16.
 */
public class URLify {
    public static void main(String [] args) {
        char [] cc = new char[30];
        String str = "H  el lo !";
        char [] ccStr = str.toCharArray();
        for (int i = 0; i < ccStr.length; i++) {
            cc[i] = ccStr[i];
        }

        replace(cc, str.length());

        for (char c : cc) {
            System.out.print(c);
        }
    }

    private static void replace(char[] ch, int length) {
        int spaceCount = 0;
        for (char c: ch) {
            if (c == ' ') spaceCount++;
        }
        int newLength = length + spaceCount * 2 - 1;
        for (int i = length-1; i >= 0; i--) {
            if(ch[i] == ' '){
                ch[newLength--] = '0';
                ch[newLength--] = '2';
                ch[newLength--] = '%';
            }
            else
                ch[newLength--] = ch[i];
        }
    }
}
