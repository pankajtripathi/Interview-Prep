package com.practice.dp;

/**
 * Created by pankajtripathi on 12/18/16.
 */
public class SubsetPartition {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 1};
        System.out.println("Without DP: " + findMinWithoutDP(arr));
    }

    private static int findMinWithoutDP(int[] arr) {
        int total = 0;
        for(int a: arr) total += a;
        return findMinRec(arr, arr.length, total, 0);
    }

    private static int findMinRec(int[] arr, int n, int total, int calculated) {
        // If we have reached last element.  Sum of one
        // subset is sumCalculated, sum of other subset is
        // sumTotal-sumCalculated.  Return absolute difference
        // of two sums.
        if(n == 0) return Math.abs((total-calculated) - calculated);

        // For every item arr[i], we have two choices
        // (1) We do not include it first set
        // (2) We include it in first set
        // We return minimum of two choices
        return Math.min(findMinRec(arr, n-1, total, calculated),
                findMinRec(arr, n-1, total, calculated+arr[n-1]));
    }
}
