package com.practice.arrays;

/**
 * Created by pankajtripathi on 12/20/16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class PermutationsNCombinations{
    static List<String> resP = new ArrayList<>();
    static List<String> resC = new ArrayList<>();
    public static void main(String args[]){
        PermutationsNCombinations obj = new PermutationsNCombinations();
        int a[] = {1, 2, 3};
        String s = "123";

        obj.permutations(s.toCharArray(), 0, s.length()-1);
        System.out.println("Permutations: " + resP);

        obj.combinations("",  a);
        System.out.println("Combinations: " + resC);
    }

    public void combinations(String soFar, int a[]){
        if(a.length == 0) resC.add(soFar);
        else{
            combinations(soFar + a[0], Arrays.copyOfRange(a, 1, a.length));
            combinations(soFar, Arrays.copyOfRange(a, 1, a.length));
        }
    }

    public void permutations(char[] ch, int l, int h){
        if(l == h) resP.add(new String(ch));
        else{
            for(int i=l; i<=h; i++){
                swap(ch, l, i);
                permutations(ch, l+1, h);
                swap(ch, l, i);
            }
        }
    }

    public void swap(char[] a, int i, int j){
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
