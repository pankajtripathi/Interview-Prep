package com.practice.dp;

/**
 * Created by pankajtripathi on 11/17/16.
 */

public class UniquePaths {
    static int stack[];
    private int top = 0;

    public static void main(String[] args) {
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };
        stack = new int[matrix.length * matrix[0].length];
        new UniquePaths().uniquePaths(matrix, 3, 3);
        System.out.println(new UniquePaths().uniquePathsCount(3, 3));
    }

    private int uniquePathsCount(int m, int n) {
        /*
        if(m == 0 || n == 0) return 0;
        int[][] count = new int[m][n];

        for (int i = 0; i < m; i++)
            count[i][0] = 1;

        for (int i = 0; i < n; i++)
            count[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                count[i][j] = count[i-1][j] + count[i][j-1] + count[i-1][j-1];
            }
        }
        return count[m-1][n-1];
        */

        if(m == 1 || n == 1) return 1;
        return uniquePathsCount(m-1, n) + uniquePathsCount(m, n-1) + uniquePathsCount(m-1, n-1);
    }

    private void uniquePaths(int[][] matrix, int m, int n){
        if(m == 0 || n == 0) return;
        stack[++top] = matrix[m-1][n-1];

        if(m == 1 && n == 1) printStack();

        uniquePaths(matrix, m-1, n);
        uniquePaths(matrix, m, n-1 );
        uniquePaths(matrix, m-1, n-1 );

        top--;
    }

    private void printStack() {
        for (int i = top; i > 1; i--)
            System.out.print(stack[i] + "->");
        System.out.println(stack[1]);
    }

    /*
    * 1   2   3
    * 4   5   6
    * 7   8   9
    * */
}