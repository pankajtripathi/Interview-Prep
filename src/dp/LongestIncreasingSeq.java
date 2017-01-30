package com.practice.dp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by pankajtripathi on 10/29/16.
 */

/**
 * for each num in nums
        if(list.size()==0)
            add num to list
        else if(num > last element in list)
            add num to list
        else
            replace the element in the list which is the smallest but bigger than num

        -idx-1 beacuse if binarySearch does not find the element it returns -insertionIndex-1
 *
 * */

public class LongestIncreasingSeq {
    public static void main(String[] args) {
        int a[] = {10,9,2,5,3,7,101,18};
        System.out.println(longestSeqDP(a));
        System.out.println(longestSeq(a));
    }

    private static int longestSeqDP(int[] a) {
        if(a.length == 0 || a== null) return a.length;

        int res = 1;
        int[] len = new int[a.length];
        for (int i = 0; i < len.length; i++) len[i] = 1;

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if(a[i] > a[j]){
                    len[i] = Math.max(len[i], len[j]+1);
                }
            }
            res = Math.max(len[i], res);
        }
        return res;
    }

    private static int longestSeq(int[] a){
        if(a.length == 0 || a== null) return a.length;
        ArrayList<Integer> list = new ArrayList<>();

        for(int num:a){
            if(list.size() == 0 || num > list.get(list.size() - 1))
                list.add(num);
            else{
                int idx = Collections.binarySearch(list, num);
                list.set(idx < 0 ? -idx - 1 : idx, num);
            }
        }
        return list.size();
    }
}
