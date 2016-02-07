package sorting;

public class Bubble_Sort {
	public static void main(String args[]){
		int a[]={65,25,12,22,11};

		boolean b=true;
		for(int i=0;i<a.length-1;i++)
		{
			for(int j=0;j<a.length-1&&b;j++){
				int temp;
				if(a[j]<a[j+1])
				{
					b=false;
					temp=a[j+1];
					a[j+1]=a[j];
					a[j]=temp;
				}

			}
			for(int k=0;k<a.length;k++)
				System.out.print(a[k]+" ");
			System.out.println("");
		}
	}
}
