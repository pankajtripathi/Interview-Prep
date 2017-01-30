package com.practice.strings;

import java.util.*;

/**
 * Created by pankajtripathi on 1/4/17.
 */
public class Anagram {
    public static void main(String[] args) {
        String[] str = {"eat", "tea", "tan", "ate", "nat", "bat"};
        checkAnagram(str);
    }

    private static void checkAnagram(String[] str) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        Arrays.sort(str);

        for(String s: str){
            char ca[] = s.toCharArray();
            Arrays.sort(ca);
            String st = String.valueOf(ca);

            if(map.containsKey(st))
                map.get(st).add(s);
            else{
                List<String> el = new ArrayList<>();
                el.add(s);
                map.put(st, el);
            }
        }

        System.out.println(map.values());
    }
}
