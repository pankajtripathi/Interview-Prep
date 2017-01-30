package com.datastructures.arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 10/23/16.
 */
public class StringCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String str = scanner.nextLine();
        compress(str);
    }

    private static void compress(String str) {
        String res = "";
        if(str.length() == 0 || str.length() == 1) return;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: str.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, ++count);
            }
            else map.put(c, 1);
        }
        System.out.println(map);
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            res += entry.getKey() + "" + entry.getValue();
        }

        if(str.length() > res.length())
            System.out.println(res);
        else System.out.println(str);
    }
}
