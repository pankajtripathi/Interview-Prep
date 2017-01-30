package com.practice.dp;

/**
 * Created by pankajtripathi on 12/17/16.
 */
public class FlowerGarden {
    public static void main(String[] args) {
        int[] height = {1,2,3,4,5,6};
        int[] bloom = {1,3,1,3,1,3};
        int[] wilt = {2,4,2,4,2,4};
        int[] order = getOrdering(height, bloom, wilt);
        for(int h: order) System.out.print(h + " ");
    }

    private  static int[] getOrdering(int[] height, int[] bloom, int[] wilt){
        int[] ordering = new int[height.length];
        int[][] conflictMatrix = getConflictMatrix(height, bloom, wilt);
        int[] picked = new int[height.length];

        for (int i = 0; i < height.length; i++) {
            int idx = flowerWithMaxHeight(conflictMatrix, height, picked);
            picked[idx] = 1;
            ordering[i] = height[idx];
            updateConflictMatrix(idx, conflictMatrix);
        }
        return ordering;
    }

    private static void updateConflictMatrix(int idx, int[][] conflictMatrix) {
        for (int i = 0; i < conflictMatrix.length; i++) {
            conflictMatrix[idx][i] = 0;
        }
    }

    /**
     *  Get the index of the plant with maximum height, which can be
     *  a plant:
     *  (1) that has no conflicts with other plants
     *  (2) that has shorter height in a time conflict with another plant
     */
    private static int flowerWithMaxHeight(int[][] conflictMatrix, int[] height, int[] picked) {
        int maxId = -1, maxHeight = -1;
        for (int i = 0; i < picked.length; i++) {
            if(picked[i] == 1) continue;
            boolean canBePicked = true;

            for (int j = 0; j < picked.length; j++)
                if(conflictMatrix[j][i] == 1){
                    canBePicked = false;
                    break;
                }

            if(canBePicked && height[i] > maxHeight){
                maxHeight = height[i];
                maxId = i;
            }
        }
        return maxId;
    }

    /**
     *  Returns a conflicts matrix mat in which,
     *     mat[i][j] is 1 if there is a conflicts between plant i and plant j,
     *     and height[i] < height[j]
     */
    private static int[][] getConflictMatrix(int[] height, int[] bloom, int[] wilt) {
        int[][] conflictMatrix = new int[height.length][height.length];
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                if(bloom[i] <= bloom[j] && bloom[j] <= wilt[i] || bloom[j] <= bloom[i] && bloom[i] <= wilt[j]){
                    if(height[i] < height[j])
                        conflictMatrix[i][j] = 1;
                    else
                        conflictMatrix[j][i] = 1;
                }
            }
        }
        return conflictMatrix;
    }
}
