package com.practice.strings;

/**
 * Created by pankajtripathi on 1/4/17.
 */
public class LongestPalindromicString {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println("Longest Palindromic String: " + new LongestPalindromicString().getLPS(str));
    }

    private String getLPS(String str) {
        String pal = "", longest = getSubstring(str, 0, 1);
        for(int i=0; i<str.length(); i++){
            pal = getSubstring(str, i, i);
            if(pal.length() > longest.length()) longest = pal;

            pal = getSubstring(str, i, i+1);
            if(pal.length() > longest.length()) longest = pal;
        }

        return longest;
    }

    private String getSubstring(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start+1, end);
    }
}
