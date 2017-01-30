package com.practice.interview;

/**
 * Created by pankajtripathi on 9/28/16.
 */
public class AlternateStrings {

    public static void main(String[] args) {
        System.out.println(verifyMergedStrings("abc","defgh","adbecfgh"));
    }

    static int verifyMergedStrings(String str1, String str2, String str3) {
        String a, b, c;

        if (str1.length() < str2.length()) {
            a = str1;
            if (str2.length() < str3.length()) {
                b = str2;
                c = str3;
            } else {
                c = str2;
                b = str3;
            }
        } else {
            a = str2;
            if (str1.length() < str3.length()) {
                b = str1;
                c = str3;
            } else {
                b = str3;
                c = str1;
            }
        }

        int common = Math.min(a.length(), b.length());
        int i = 0;
        String s = "";
        while (i < common) {
            s += a.charAt(i) + "" + b.charAt(i);
            i++;
        }
        while (i < a.length()) {
            s += a.charAt(i);
            i++;
        }
        while (i < b.length()) {
            s += b.charAt(i);
            i++;
        }

        if (s.equals(c)) return 1;
        return 0;
    }
}
