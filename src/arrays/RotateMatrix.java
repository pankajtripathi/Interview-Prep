package com.datastructures.arraysandstrings;

/**
 * Created by pankajtripathi on 10/23/16.
 */
public class RotateMatrix {
    static int matrix[][] = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    public static void main(String[] args) {
        rotateLeft();
        //rotateRight();
    }

    private static void rotateRight() {
        swapRows();
        transpose();
        printMatrix();
    }

    private static void rotateLeft() {
        transpose();
        swapRows();
        printMatrix();
    }

    private static void swapRows() {
        for (int i = 0, k = matrix.length - 1; i < k; i++, k--) {
            int t[] = matrix[k];
            matrix[k] = matrix[i];
            matrix[i] = t;
        }
    }

    private static void transpose(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    private static void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
