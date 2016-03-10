package sorting;

/**
 * @author pankajtripathi
 * */
public class Selection_Sort {
	public static void main(String args[]){
		int a[]={64,25,12,22,11};

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
			for(int k=0;k<a.length;k++)
				System.out.print(a[k]+" ");
			System.out.println("");
		}
	}
}
