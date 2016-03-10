package searching;

import java.util.Scanner;

/**
 * @author pankajtripathi
 * */
public class Binary_Search {

	public static int binary_search(int a[],int num, int low, int high){

		int mid;
		while(low <= high){

			mid=(low+high)/2;

			if(a[mid]==num)
				return mid;

			else if(a[mid] > num)
				high= mid-1;
			else
				low=mid+1;
		}
		return -1;
	}

	public static void sort(int a[]){
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=i+1;j<a.length;j++)
			{
				if(a[i]>a[j])
				{
					int temp;
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int a[];

		System.out.println("Enter the no of elements needed");
		int n=s.nextInt();
		a=new int[n];

		System.out.println("Enter "+n +" elements");
		for(int i=0;i<n;i++)
			a[i]=s.nextInt();

		System.out.println("Enter the element to be searched");
		int num=s.nextInt();

		sort(a);

		int index=binary_search(a,num,0,n-1); 
		System.out.println("Element at index "+ index);
	}

}
