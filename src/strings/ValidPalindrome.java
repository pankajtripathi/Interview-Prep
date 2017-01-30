package com.practice.strings;

/**
 * Created by pankajtripathi on 1/17/17.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        new ValidPalindrome().check(str);
    }

    private void check(String s){
        String extract = s.replaceAll("[^0-9a-bA-B]+", "").trim().toLowerCase();
        StringBuilder sb = new StringBuilder(extract);
        if(sb.reverse().toString().equals(extract)) System.out.println("True");
        else System.out.println("False");
    }

}
