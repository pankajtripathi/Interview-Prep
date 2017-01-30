package com.practice.dp;

import java.util.Scanner;

/**
 * Created by pankajtripathi on 12/18/16.
 */
public class StepCount {
    public static void main(String[] args) {
        System.out.println("Enter distance");
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        System.out.println("Step count without DP: " + stepCountWithoutDP(dist));
        System.out.println("Step count with DP: " + stepCount(dist));
    }

    private static int stepCount(int dist) {
        int[] dp = new int[dist + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= dist; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        return dp[dist];
    }

    private static int stepCountWithoutDP(int dist) {
        if(dist < 0) return 0;
        if(dist == 0) return 1;
        return stepCountWithoutDP(dist-1) + stepCountWithoutDP(dist-2) + stepCountWithoutDP(dist-3);
    }
}
