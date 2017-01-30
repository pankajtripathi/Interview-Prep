package com.practice.arrays;

/**
 * Created by pankajtripathi on 12/12/16.
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int m[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new SpiralMatrix().printSpiral(m);
    }

    public void printSpiral(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0) return;

        int topRow = 0, bottomRow = m.length-1;
        int leftCol = 0, rightCol = m[0].length-1;

        while (topRow <= bottomRow && leftCol <= rightCol){
            // Print elements from start of col to end of top row
            for (int i = leftCol; i <= rightCol; i++)
                System.out.print(m[topRow][i] + " ");
            topRow++;

            // Print elements from start of row to end of right column
            for (int i = topRow; i <= bottomRow; i++)
                System.out.print(m[i][rightCol] + " ");
            rightCol--;

            // Print elements from end to start of bottom row
            if(topRow <= bottomRow){
                for (int i = rightCol; i >= leftCol; i--)
                    System.out.print(m[bottomRow][i] + " ");
                bottomRow--;
            }

            // Print elements from end to start of right column
            if(leftCol <= rightCol){
                for (int i = bottomRow; i >= topRow; i--)
                    System.out.print(m[i][leftCol] + " ");
                leftCol++;
            }
        }
    }
}
