package arrays;

import java.util.Scanner;

/**
 * @author pankajtripathi
 * Get the Occurrences of all the digits in a number and print the one with the most occurrences
 */
public class Occurrences {
    static long occurrence(long n,long i){
        long count=0;
        while(n!=0){
            if(n%10 == i)
                count++;
            n=n/10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number");
        long n=scanner.nextLong();
        long countForNum=-1,maxCount=-1,maxCountNum = 0;

        for(long i=0;i<=9;i++){
            countForNum = occurrence(n,i);
            if(countForNum != 0)
            System.out.println("Occurrence for "+i+" is "+countForNum);

            if(countForNum > maxCount) {
                maxCount = countForNum;
                maxCountNum = i;
            }
        }

        System.out.println("Number with max occurrences is "+maxCountNum);
        scanner.close();

    }
}