    package com.practice.arrays;

    /**
     * Created by pankajtripathi on 10/15/16.
     */
    public class ArrayEquilibrium {
            public static void main(String[] args) {
                int arr[]={1,1};
                System.out.print(isArray_Balanced(arr));
            }

            static int isArray_Balanced(int[] arr) {
                int length = arr.length;
                int sum = getSum(arr);
                int leftSum = 0;

                if(length == 0) return -1;

                for(int i=0; i<length; i++) {
                    sum -= arr[i];
                    if (leftSum == sum) return i;
                    leftSum += arr[i];
                }

                return -1;
            }

            static int getSum(int[] arr) {
                int sum = 0;
                for(int i=1; i<arr.length; i++)
                    sum += arr[i];
                return sum;
            }
    }
