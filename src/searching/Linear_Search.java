package searching;

import java.util.Scanner;
/**
 * @author pankajtripathi
 * */
public class Linear_Search {

	public static void liner_search(int a[],int num){

		int i;
		for(i=0;i<a.length;i++)
		{
			if(a[i]==num)
				break;
		}
		System.out.println("Element at index "+ (i+1));
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

		liner_search(a,num);   
	}

}
