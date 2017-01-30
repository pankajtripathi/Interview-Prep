package com.practice.arrays;

import java.util.HashSet;

/**
 * Created by pankajtripathi on 1/9/17.
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(new LongestConsecutiveSequence().getLCS(arr));
    }

    private int getLCS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        HashSet<Integer> hash = new HashSet<>();

        for (int num: nums) hash.add(num);

        for(int num: nums){
            int res = 0, start;
            if(!hash.contains(num-1)){
                start = num;
                while(hash.contains(start)){
                    start++;
                    res++;
                }
                if(res > max) max = res;
            }
        }
        return max;
    }
}
