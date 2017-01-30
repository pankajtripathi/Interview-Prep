package com.practice.dp;

/**
 * Created by pankajtripathi on 12/17/16.
 */
public class CollectApples {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {1, 1, 1, 1},
                {9, 9, 9, 9}
        };
        System.out.println(maxApples(A, A.length, A[0].length));
    }

    private static int maxApples(int[][] a, int m, int n) {
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    if(i > 0 && j > 0)
                        count[i][j] = a[i][j] + Math.max(count[i][j-1], count[i-1][j]);
                    else
                        count[i][j] = a[i][j];
            }
        }
        return count[m-1][n-1];
    }
}
