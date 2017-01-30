package com.practice.dp;

/**
 * Created by pankajtripathi on 12/18/16.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int resD = new LongestCommonSubsequence().LCSWihtoutDP(X, Y, X.length(), Y.length());
        int res = new LongestCommonSubsequence().LCS(X, Y, X.length(), Y.length());
        System.out.println("LCS without DP: " + resD);
        System.out.println("LCS with DP: " + res);
    }

    // O(n)
    private int LCS(String x, String y, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 || j == 0) dp[i][j] = 0;
                else if(x.charAt(i-1) == y.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[m][n];
    }

    //O(2^n)
    private int LCSWihtoutDP(String x, String y, int m, int n) {
        if(m == 0 || n == 0) return 0;
        else if(x.charAt(m-1) == y.charAt(n-1)) return 1 + LCSWihtoutDP(x, y, m-1, n-1);
        else
            return Math.max(LCSWihtoutDP(x, y, m-1, n), LCSWihtoutDP(x, y, m, n-1));
    }
}
