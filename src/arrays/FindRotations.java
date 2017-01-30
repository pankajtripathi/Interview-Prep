package com.practice.arrays;

/**
 * Created by pankajtripathi on 1/13/17.
 *
 * Find the number of times a sorted array is rotated. Such an array is called circular sorted array.
 * The array must contain only distinct elements in order to use binary search.
 */
public class FindRotations {
    public static void main(String[] args) {
        int[] arr = {5, 9, 14, 1, 3, 4};
        System.out.println(new FindRotations().findRotations(arr));
    }

    private int findRotations(int[] arr) {
        int n = arr.length;
        int low = 0, high = arr.length-1;

        while(low <= high){
            if(arr[low] <= arr[high]) return low; // Case-1 array is already sorted

            int mid = (low + high) / 2;
            int next = (mid + 1)  % n;
            int prev = (mid + n - 1) % n;

            if(arr[mid] <= arr[next] && arr[mid] <= arr[prev]) return mid;  // Case-2 mid is the starting element

                // Case-3 discard one part of array
            else if(arr[mid] <= arr[high]) high = mid -1;
            else if(arr[mid] >= arr[low]) low = mid + 1;

        }
        return -1;
    }
}
