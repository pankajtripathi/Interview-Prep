package arrays;

/**
 * Get the index of array where the sum of numbers on right of index is equal to sum of numbers on left.
 * */
public class Equilibrium {
	private static int getEquiIndex(int a[]){
		int leftsum=0,sum=0;
		for(int i=0;i<a.length;i++)
			sum=sum+a[i]; 
		for(int i=0;i<a.length;i++){
			sum = sum -a[i];   // update sum to include sum of numbers on right
			if(leftsum == sum)
				return i;
			leftsum = leftsum + a[i]; //update leftsum to include numbers on left
		}
		return -1; //No such index
	}
	public static void main(String[] args) {
		int a[]={-7, 1, 5, 2, -4, 3, 0};
		System.out.println(getEquiIndex(a));
	}
}
