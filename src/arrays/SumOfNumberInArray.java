package arrays;

import sorting.Heap_Sort;
import java.util.Scanner;

/**
 * Created by pankajtripathi on 2/3/16.
 */
public class SumOfNumberInArray {
	public static boolean findsum(int num, int arr[]){
		int l=0,r=arr.length-1;
		int sum=num;
		while(l<r){
			if(arr[l]+arr[r]==sum)
				return true;
			else if(arr[l]+arr[r]<sum)
				l++;
			else
				r--;
		}
		return false;
	}
	public static void main(String args[]){
		int n;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the no of elements");
		n=s.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the "+n+" elements");
		for(int i=0;i<n;i++)
		{
			a[i]=s.nextInt();
		}
		Heap_Sort obj=new Heap_Sort();
		obj.sort(a);
		System.out.println("Enter the number");
		int num=s.nextInt();
		if(findsum(num,a))
			System.out.println("Sum of number present in array");
		else
			System.out.println("Sum of number not present in array");
	}
}
