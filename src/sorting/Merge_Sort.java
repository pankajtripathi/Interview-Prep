package sorting;

public class Merge_Sort {
	public static void main(String args[]){

		int a[]={65,25,12,22,11,102,14,38,26};

		a= divide(a);

		for(int k=0;k<a.length;k++)
			System.out.print(a[k]+" ");

	}

	// Method to divide the array into multiple array for sorting
	public static int[] divide(int B[]){

		//keep dividing the array till it's of size one
		if(B.length<=1)
			return B;

		int mid= B.length/2;

		int left[]=new int[mid];

		int right[];

		//if mid=(4/2) then it will work but if mid=(5/2) in this case right will be of size 3 
		//and left of size 2 

		if(B.length%2==0)
			right=new int[mid];
		else
			right=new int[mid+1];

		//Array to store result
		int res[]=new int[B.length];

		//initializing the left and right array
		for(int i=0;i<mid;i++)
			left[i]=B[i];

		int x=0;
		for (int j=mid;j<B.length;j++)
		{   
			if(x < right.length){
				right[x]=B[j];
				x++;
			}
		}

		//keep dividing the arrays by recursion
		left = divide(left);
		right= divide(right);

		//result via merging
		res= merge(left,right);
		return res;
	}

	public static int[] merge(int L[], int R[])
	{
		int resLength=L.length + R.length;
		int res[]=new int[resLength];
		int indexL=0;
		int indexR=0;
		int indexRes=0;

		//Keep repeating the process till I have elements in both the arrays

		while(indexL<L.length || indexR< R.length){

			//we need to check if there are elements in both the arrays, if yes we need to 
			//keep on merging the arrays

			if(indexL<L.length && indexR< R.length)
			{
				//if no in left array is smaller than right then put in res array
				if(L[indexL] <= R[indexR]){

					res[indexRes]=L[indexL];
					indexL++;
					indexRes++;
				}
				else{

					res[indexRes]=R[indexR];
					indexR++;
					indexRes++;
				}
			}

			//if right array is empty then perform only for left array
			else if(indexL < L.length){

				res[indexRes]=L[indexL];
				indexL++;
				indexRes++;
			}

			//if left array is empty then perform only for right array
			else if(indexR < R.length){

				res[indexRes]=R[indexR];
				indexR++;
				indexRes++;
			}
		}
		return res;
	}
}
