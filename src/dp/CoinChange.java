package com.practice.dp;

import java.util.Scanner;

/**
 * Created by pankajtripathi on 12/15/16.
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the sum required: ");
        int reqSum = scanner.nextInt();
        coinChange(coins, reqSum);
    }

    private static void coinChange(int[] coins, int sum) {
        int[] min = new int[sum+1];
        for (int i = 0; i <= sum; i++)
            min[i] = 999;
        min[0] = 0;

        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < coins.length; j++) {

                // 1. check if the current coin value is less than or equal to the current required sum
                // 2. Also check if the min value of it previous mins is less than default min.
                int Vj = coins[j];
                if(Vj <= i && min[i - Vj] + 1 < min[i])
                    min[i] = min[i - Vj] + 1;
            }
        }

        if(min[sum] >= 999) System.out.println("Min coins: " + -1);
        else System.out.println("Min coins: " + min[sum]);
    }
}
