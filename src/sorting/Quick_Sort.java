package sorting;

import java.util.Scanner;

/**
 * @author pankajtripathi
 * */
public class Quick_Sort {
	
	private static void sort(int a[], int low, int high)
	{
		if(a.length == 0 || a.length == 1) return;
		if(low >= high) return;
		
		int mid = (low + high) / 2;
		int pivot = a[mid];
		int i = low, j = high;
		
		while(i <= j){
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

	public static void main(String[] args) {
		int n;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the no of elements");
		n=s.nextInt();
			
		int a[]=new int[n];
		
		System.out.println("Enter the "+n+" elements");
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();

		sort(a);

		System.out.println("Elements after final sorting");
		for(int i=0;i<n;i++)
			System.out.print(a[i]+" ");
	}
}
