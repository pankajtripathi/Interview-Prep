package com.practice.arrays;

/**
 * Created by pankajtripathi on 1/17/17.
 */
import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(findMissingNumber(arr));
    }

    private static List<Integer> findMissingNumber(int[] arr) {
        if(arr == null || arr.length == 0) return null;
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            int val = Math.abs(arr[i]) - 1;
            if(arr[val] > 0) arr[val] = -arr[val];
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) res.add(i+1);
        }

        return res;
    }
}
