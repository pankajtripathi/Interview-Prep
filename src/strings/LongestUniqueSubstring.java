package com.practice.strings;

import java.util.*;

/**
 * Created by pankajtripathi on 1/17/17.
 */
public class LongestUniqueSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LongestUniqueSubstring().getLength(s));
    }

    private int getLength(String s) {
        if(s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for(int i=0, j=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c))
                j = Math.max(j, map.get(c) + 1);
            map.put(c, i);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
