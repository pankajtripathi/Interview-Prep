package com.practice.arrays;

/**
 * Created by pankajtripathi on 1/13/17.
 *
 * Find an element in a circular sorted array.
 * The array should not contain any duplicate elements.
 */

public class CircularSortedArraySearch {
    public static void main(String[] args) {
        int[] arr = {5, 9, 14, 1, 3, 4};
        System.out.println(new CircularSortedArraySearch().findElement(arr, 9));
    }

    private int findElement(int[] arr, int x) {
        if(arr == null || arr.length == 0) return -1;
        int low = 0, high = arr.length-1;
        if(x < arr[low] && x > arr[high]) return -1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == x) return mid;  // Case-1 element found at mid.

            //Case-2 right side of mid is sorted.
            if(arr[mid] <= arr[high]){
                if(x > arr[mid] && x <= arr[high]) low = mid + 1;
                else high = mid - 1;
            }
            //Case-3 left side of mid is sorted.
            else{
                if(x < arr[mid] && x >= arr[low]) high = mid - 1;
                else low = mid + 1;
            }

        }
        return -1;
    }
}
