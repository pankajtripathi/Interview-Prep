package com.practice.dp;

/**
 * Created by pankajtripathi on 12/18/16.
 */
public class Knapsack {
    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println("KnapSack Without DP: " + knapSackWithoutDP(W, wt, val, n));
        System.out.println("KnapSack With DP: " + knapSack(W, wt, val, n));
    }

    private static int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i < dp.length; i++) {
            for (int w = 0; w < dp[0].length; w++) {
                if(i == 0 || w == 0) dp[i][w] = 0;
                else if(wt[i-1] > w) dp[i][w] = dp[i-1][w];
                else dp[i][w] = Math.max(val[i-1] + dp[i-1][w-wt[i-1]], dp[i-1][w]);
            }
        }
        return dp[n][W];
    }

    private static int knapSackWithoutDP(int W, int[] wt, int[] val, int n) {
        if(n == 0 || W == 0) return 0;

        //Check weight of last item
        else if(wt[n-1] > W) return knapSackWithoutDP(W, wt, val, n-1);

        //Return max of two cases 1. last item included 2. last item excluded
        else return Math.max(val[n-1] + knapSackWithoutDP(W-wt[n-1], wt, val, n-1), knapSackWithoutDP(W, wt, val, n-1));
    }
}
