package com.practice.strings;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by pankajtripathi on 1/9/17.
 */
public class StringToInt {
    public static void main(String[] args) {
        String str = "124";
        System.out.println(new StringToInt().myAtoi(str));
    }

    private int myAtoi(String str) {
        int index = 0, sign = 1, res = 0;

        //1. Empty string
        if(str == null || str.length() == 0) return 0;

        //2. Remove spaces
        while (str.charAt(index) == ' ' && index < str.length()) index++;

        //3. Check sign
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //4. Calculate
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            if(Integer.MAX_VALUE/10 < res || Integer.MAX_VALUE/10 == res && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res*10 + digit;
            index++;
        }
        return sign*res;
    }
}
