package com.practice.strings;

/**
 * Created by pankajtripathi on 12/20/16.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"ab", "abc", "abcd"};
        System.out.println(lcp(strs));
    }

    private static String lcp(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        int minLen = Integer.MAX_VALUE;

        for(String str: strs)
            minLen = Math.min(minLen, str.length());

        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < strs.length-1; j++) {
                String s1 = strs[j];
                String s2 = strs[j+1];
                if(s1.charAt(i) != s2.charAt(i))
                    return s1.substring(0, i);
            }
        }
        return strs[0].substring(0, minLen);
    }
}
