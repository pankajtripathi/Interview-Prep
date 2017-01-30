package com.practice.dp;

import java.util.Arrays;

/**
 * Created by pankajtripathi on 12/17/16.
 */
public class BadNeighbors {
    public static void main(String[] args) {
        int[] donations = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        System.out.println(maxDonations(donations));
    }

    private static int maxDonations(int[] donations){
        int N = donations.length;

        int sum1 = maxSubSum(Arrays.copyOfRange(donations, 0, N-1));
        int sum2 = maxSubSum(Arrays.copyOfRange(donations, 1, N-2)) + donations[N-1];

        return Math.max(sum1, sum2);
    }

    private static int maxSubSum(int[] donations){
        int N = donations.length;

        if(N == 0) return 0;
        if(N == 1) return donations[0];
        if(N == 2) return Math.max(donations[0] , donations[1]);

        int sum1 = maxSubSum(Arrays.copyOfRange(donations, 0, N-1));
        int sum2 = maxSubSum(Arrays.copyOfRange(donations, 0, N-2)) + donations[N-1];

        return Math.max(sum1, sum2);
    }
}
