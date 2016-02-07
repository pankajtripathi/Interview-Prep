package sorting;

public class Insertion_Sort {

	public static void main(String args[]){
		int a[]={65,25,12,22,11};
		int val;
		for(int i=1;i<a.length;i++)
		{   
			int j;
			val=a[i];
			for(j=i-1;j>=0&&a[j]>val;j--)
				a[j+1]=a[j];

			a[j+1]=val;

			for(int k=0;k<a.length;k++)
				System.out.print(a[k]+" ");
			System.out.println("");
		}

	}
}
