package com.practice.dp;

/**
 * Created by pankajtripathi on 1/18/17.
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money
 * stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 */
public class HouseRobber {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4};
        System.out.println(rob(arr));
    }

    private static int rob(int[] arr) {
        if(arr == null || arr.length == 0) return 0;
        int even = 0, odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0){
                even += arr[i];
                even = Math.max(even, odd);
            }
            else {
                odd += arr[i];
                odd = Math.max(odd, even);
            }
        }
        return Math.max(even, odd);
    }
}
