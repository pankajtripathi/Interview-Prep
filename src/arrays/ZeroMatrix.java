package com.datastructures.arraysandstrings;

/**
 * Created by pankajtripathi on 10/24/16.
 */
public class ZeroMatrix {
    static int matrix[][] = {
            {0, 1},{2, 3},{4,5}
    };


    public static void main(String[] args) {
        //searchZeroMN();
        searchZero();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void searchZeroMN() {
        int row=0, col = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row = i;
                    col = j;

                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i == row || j == col){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    private static void searchZero(){
        int row = 0, col = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0){
                    row = i;
                    col = j;

                }
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if(i == row) nullifyRows(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            if(i == col) nullifyCols(i);
        }


    }

    private static void nullifyCols(int col) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }

    private static void nullifyRows(int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }
}
