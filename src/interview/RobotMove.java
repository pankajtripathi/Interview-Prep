package com.practice.interview;

/**
 * Created by pankajtripathi on 10/14/16.
 */
public class RobotMove {
    public static void main(String[] args) {
        RobotMove obj = new RobotMove();
        System.out.println(obj.check(1, 1, 1, 2));
    }

    private String check(int a, int b, int c, int d) {
        int tempA = a, tempB = b;
        while(tempA <= 1000){
            if(tempA == c) {
                while (tempB <= 1000) {
                    if (tempB == d) return "Yes";
                    tempB += a;
                }
            }
            tempA += b;
        }
        return "No";
    }
}
