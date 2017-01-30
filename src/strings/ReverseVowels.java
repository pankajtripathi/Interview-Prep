package com.practice.strings;

/**
 * Created by pankajtripathi on 1/9/17.
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseVowels(str));
    }

    /*
    * Two pointer approach.
    * start and end of the string
    * create a string with vowels in uppercase and lowercase.
    * keep checking the input string for the vowels from start as well as end.
    * once found swap and move pointers.
    * */

    public static String reverseVowels(String s) {
        if(s == null || s.length() == 0) return "";
        int start = 0;
        int end = s.length()-1;
        String vowels = "aeiouAEIOU";
        char[] ch = s.toCharArray();

        while(start <= end){
            while(start <  end && !vowels.contains(ch[start] + ""))
                start++;
            while(end > start && !vowels.contains(ch[end] + ""))
                end--;

            char t = ch[start];
            ch[start] = ch[end];
            ch[end] = t;
            start++;
            end--;

        }
        return new String(ch);
    }
}
