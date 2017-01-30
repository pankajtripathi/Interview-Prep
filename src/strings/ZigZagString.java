package com.practice.strings;

/**
 * Created by pankajtripathi on 1/17/17.
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 Show Tags

 */

public class ZigZagString {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new ZigZagString().convert(s, 3));
    }

    private String convert(String s, int numRows){
        if(s == null || s.length() == 0) return s;
        if(numRows == 1) return s;
        int cycle = 2*numRows - 2;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i <numRows; i++) {
            for (int j = i; j < s.length(); j = j + cycle) {
                res.append(s.charAt(j));
                int secondJ = j -i  + cycle - i;
                if(i != 0 && i != numRows-1 && secondJ < s.length())
                    res.append(s.charAt(secondJ));
            }
        }

        return res.toString();
    }
}
