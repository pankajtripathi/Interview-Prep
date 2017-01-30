package com.practice.graph;

/**
 * Created by pankajtripathi on 11/16/16.
 */
public class LongestPathInMatrix {
    public static void main(String[] args) {
        int matrix[][] = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        int ans = new LongestPathInMatrix().longestIncreasingPath(matrix);
        System.out.println(ans);
    }

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;

        int ans = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if(dp[i][j] == -1) {
                    int res = dfs(i, j, matrix, dp);
                    ans = Math.max(res, ans);
                }
            }
        }
        return 1 + ans;
    }

    private int dfs(int i, int j, int[][] matrix, int[][] dp) {
        if(dp[i][j] != -1) return dp[i][j];

        int one = 0, two = 0, three = 0, four = 0;
        if(i > 0 && isValid(matrix, i, j, i-1, j)) one = 1 + dfs(i-1, j, matrix, dp);
        if(i+1 < matrix.length && isValid(matrix, i, j, i+1, j)) two = 1 + dfs(i+1, j, matrix, dp);
        if(j > 0 && isValid(matrix, i, j, i, j-1)) three = 1 + dfs(i, j-1, matrix, dp);
        if(j+1 < matrix[0].length && isValid(matrix, i, j, i, j+1)) four = 1 + dfs(i, j+1, matrix, dp);

        dp[i][j] = Math.max(one, Math.max(two, Math.max(three, four)));
        return dp[i][j];
    }

    private boolean isValid(int[][] matrix, int i, int j, int ni, int nj) {
        return i >= 0 && j >= 0 && i<matrix.length && j<matrix[0].length && matrix[ni][nj] > matrix[i][j];
    }
}
