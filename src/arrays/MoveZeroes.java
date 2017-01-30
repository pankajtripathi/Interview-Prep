package com.practice.arrays;

/**
 * Created by pankajtripathi on 10/17/16.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int a[] = { 0, 1, 0, 3, 12};
        int res[] = move(a);
        for (int i = 0; i <res.length ; i++) {
            System.out.print(res[i]+" ");
        }
    }

    private static int[] move(int[] a) {
        int i = 0, j = 0;
        while (j < a.length && i < a.length) {
            if (a[j] == 0)
                j++;
            else {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j++;
            }
        }
        return a;
    }
}
