package com.practice.strings;

/**
 * Created by pankajtripathi on 1/3/17.
 */
public class KMP {
    public static void main(String[] args) {
        String str = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";
        KMP ss = new KMP();
        int result = ss.substring(str.toCharArray(), pattern.toCharArray());
        System.out.print(result);
    }

    private int substring(char[] str, char[] pattern) {
        int i = 0, j = 0;
        int[] lps = buildTable(pattern);
        while(i < str.length && j < pattern.length){
            if(str[i] == pattern[j]){
                i++;
                j++;
            }
            else{
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
        if(j == pattern.length) return i - pattern.length;
        return -1;
    }

    private int[] buildTable(char[] pattern){
        int[] lps = new int[pattern.length];
        int index = 0;
        for (int i = 1; i < pattern.length;) {
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                i++;
                index++;
            }
            else{
                if(index != 0) index = lps[index-1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
