package sorting;

import java.util.Scanner;

/**
 * @author pankajtripathi
 * */
public class QuickSort{
    public static void sort(int a[], int low, int high){
        if(a.length == 0 || a.length == 1) return;
        if(low > high) return;
        
        int mid = (high + low) / 2;
        int pivot = a[mid];
        int i=low, j=high;
        
        while(i<=j){
            while(a[i] < pivot){
                i++;
            }
            while(a[j] > pivot){
                j--;
            }
            if(i <= j){
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                
                i++;
                j--;
            }
        }
        if(low < j)
            sort(a, low, j);
        if(high > i)
            sort(a, i, high);
        
    }
    
    public static void main(String args[]){
        QuickSort obj = new QuickSort();
        int a[] = {7, 1, 3, 9, 2, 12};
        obj.sort(a, 0, a.length-1);
        
        for (int i=0;i<a.length; i++){
            System.out.print(a[i] + " ");
        } 
    }
}
