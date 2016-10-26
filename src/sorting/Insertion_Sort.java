package sorting;

/**
 * @author pankajtripathi
 * */
public class Insertion_Sort{
    public static void sort(int a[], int n){
        for(int i=1; i<=n-1; i++){
            int val = a[i];
            int hole = i;
            
            while(hole > 0 && a[hole-1] > val){
                a[hole] = a[hole-1];
                hole = hole - 1;
            }
            
            a[hole] = val;
        }
    }
    
    public static void main(String args[]){
        Insertion_Sort obj = new Insertion_Sort();
        int a[] = {7, 1, 3, 9, 2, 12};
        obj.sort(a, a.length);
        for (int i=0;i<a.length; i++){
            System.out.print(a[i] + " ");
        } 
    }
}
