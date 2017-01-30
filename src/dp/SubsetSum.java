package com.practice.dp;

/**
 * Created by pankajtripathi on 12/18/16.
 */
public class SubsetSum {
    public static void main (String args[])
    {
        int set[] = {3, 34, 12, 2};
        int sum = 14;
        int n = set.length;

        if (isSubsetSumWithoutDP(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");

        if (isSubsetSum(set, n, sum) == true)
            System.out.println("Found a subset with given sum");
        else
            System.out.println("No subset with given sum");
    }

    private static boolean isSubsetSum(int[] set, int n, int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;

        // If sum is 1, and n == 0 then answer is false
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if(set[i-1] > j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] || dp[i-1][j-set[i-1]];
            }
        }
        return dp[n][sum];
    }

    private static boolean isSubsetSumWithoutDP(int[] set, int n, int sum) {
        if(sum == 0) return true;
        else if(sum != 0 && n == 0) return false;
        else if(set[n-1] > sum) return isSubsetSumWithoutDP(set, n-1, sum);
        else return isSubsetSumWithoutDP(set, n-1, sum) || isSubsetSumWithoutDP(set, n-1, sum-set[n-1]);
    }
}
