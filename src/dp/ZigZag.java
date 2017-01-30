package com.practice.dp;

import java.util.Arrays;

/**
 * Created by pankajtripathi on 12/16/16.
 */
public class ZigZag {
    public static void main(String[] args) {
        int[] a = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955,
                600, 947, 978, 46, 100, 953, 670, 862, 568, 188,
                67, 669, 810, 704, 52, 861, 49, 640, 370, 908,
                477, 245, 413, 109, 659, 401, 483, 308, 609, 120,
                249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
        System.out.println(zigZagLength(a));
    }

    private static int zigZagLength(int[] a) {
        if(a.length <2) return a.length;
        int neg = 1, pos = 1;
        for (int i = 1; i < a.length; i++) {
            if(a[i] > a[i-1])
                pos = neg + 1;
            else if(a[i] < a[i-1])
                neg = pos + 1;
        }
        return Math.max(pos, neg);
    }
}
