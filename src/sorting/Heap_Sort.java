package sorting;

/**
 * @author pankajtripathi
 * */
public class Heap_Sort {

	private static int N;

	public static void sort(int a[]){

		heapify(a);
		for(int i=N;i>0;i--)
		{
			swap(a,i,0);
			N=N-1;
			maxheap(a,0);
		}
	}

	public static void heapify(int a[]){

		N=a.length-1;
		for(int i=N/2;i>=0;i--)
		{
			maxheap(a,i);
		}
	}

	public static void maxheap(int a[],int i){

		int left=2*i;
		int right=2*i + 1;
		int max=i;

		if(left<=N && a[left]>a[i])
		{
			max=left;
		}
		if(right<=N && a[right]>a[max])
		{
			max=right;
		}

		if(max!=i)
		{
			swap(a,max,i);
			maxheap(a,max);
		}
	}

	public static void swap(int a[],int max,int i)
	{
		int t=a[i];
		a[i]=a[max];
		a[max]=t;
	}
}
