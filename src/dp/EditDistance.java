package com.practice.dp;

/**
 * Created by pankajtripathi on 12/18/16.
 */
public class EditDistance {
    public static void main(String args[])
    {
        String str1 = "aditya";
        String str2 = "pankaj";
        System.out.println("Distance Without DP: " + editDistWithoutDP( str1 , str2 , str1.length(), str2.length()) );
        System.out.println("Distance With DP: " + editDist( str1 , str2 , str1.length(), str2.length()) );
    }

    // O(m+n)
    private static int editDist(String x, String y, int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0) dp[i][j] = j;
                else if(j == 0) dp[i][j] = i;
                else if(x.charAt(i-1) == y.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }

    //O(3^m)
    private static int editDistWithoutDP(String x, String y, int m, int n) {
        if(m == 0) return n;
        else if(n == 0) return m;
        else if(x.charAt(m-1) == y.charAt(n-1)) return editDistWithoutDP(x, y, m-1, n-1);
        else return 1 + Math.min(editDistWithoutDP(x, y, m, n-1),
                Math.min(editDistWithoutDP(x, y, m-1, n), editDistWithoutDP(x, y, m-1, n-1)));
    }
}
