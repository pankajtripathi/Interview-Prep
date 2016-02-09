package arrays;

import java.util.Scanner;

/**
 * author: Pankaj Tripathi
 * Program to compute all the permutations of numbers in an array.
 * */
public class PermutationOfNumbers {
	public static int count=0;
	/**
	 * @param a-> array of numbers whose permutations we need to compute
	 * @param start-> start element 
	 * Generate permutations of numbers in an array.
	 * */
	public static void generatePermutation(int a[],int start){
		int n=a.length;
		//If we are at the last element - nothing left to permute
        if(n == start+1){
        	System.out.println("Permutation is: ");
        	for(int i=0;i<n;i++){
        		System.out.print(a[i]+" ");
        	}
        	System.out.println();
        	count++;
        }
        else{
        	for(int i=start;i<n;i++){
        		//Swap the elements at indices start and i
        		swap(a,start,i);
        		//Recurse on the sub array a[start+1...end]
        		generatePermutation(a, start+1);
        		//Swap the elements back
        		swap(a,start,i);
        	}
        }
	}
	/**
	 * @param a array of number
	 * @param i number i
	 * @param j number j
	 * Swap two number i and j
	 * */
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the number of elements for the array");
		int n = scan.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the numbers in array");
        for (int i = 0; i < a.length; i++) {
			a[i]=scan.nextInt();
		}
        generatePermutation(a,0);
        System.out.println("Total combinations are "+count);
        scan.close();
	}
}
