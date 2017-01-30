package com.practice.strings;

/**
 * Created by pankajtripathi on 1/17/17.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("20", "30"));
    }

    private String multiply(String num1, String num2){
        if(num1.length() == 0 || num2.length() == 0) return "0";
        int n1 = num1.length(), n2 = num2.length();
        int carry = 0;
        int[] prod = new int[n1+n2];

        for(int i=n1-1; i>= 0; i--){
            for (int j = n2-1; j >= 0 ; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                prod[i+j+1] += d1*d2;
            }
        }

        for(int i=prod.length-1; i>=0; i--){
            int temp = (prod[i] + carry) % 10;
            carry = (prod[i] + carry) / 10;
            prod[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int n:prod) sb.append(n);

        while(sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();

    }
}
