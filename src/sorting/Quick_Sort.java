package sorting;

import java.util.Scanner;

public class Quick_Sort {

	public static void sort(int a[]){
		if(a.length <= 1)
			return;
		sort(a,0,a.length-1);
	}

	private static void sort(int a[],int lo,int hi)
	{
		if((hi-lo) <= 0) //fewer than 2 items
			return;

		int splitPoint = split(a,lo,hi);

		sort(a,lo,splitPoint-1); //sorting left sub array
		sort(a,splitPoint+1,hi);//sorting right sub array
	}

	private static int split(int a[],int lo,int hi)
	{
		int left=lo+1;
		int right=hi;      
		int pivot=a[lo];  

		while(true){
			while(left <= right)             //move left till it is less than right
			{
				if(a[left] < pivot)         //element at left is less than right, so increment left
					left++;
				else
					break;
			}

			while(right > left)            //move right till it is greater than left
			{
				if(a[right] > pivot)       //element at right is greater than left, so decrement right
					right--;
				else
					break;
			}

			if(left >= right)
			{
				break;
			}

			// swap the elements
			int temp=a[left];
			a[left]=a[right];
			a[right]=temp;

			// move one step forward
			right--;
			left++;
		}

		//swap pivot with left-1
		a[lo]=a[left-1];
		a[left-1]=pivot;

		//return splitPoint
		return left-1;
	}

	public static void main(String[] args) {
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

		sort(a);

		System.out.println("Elements after final sorting");
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}	

	}

}
