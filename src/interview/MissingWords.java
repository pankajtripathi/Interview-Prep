package com.practice.interview;

import java.util.LinkedList;

/**
 * Created by pankajtripathi on 10/6/16.
 */
public class MissingWords {
    public static void main(String[] args) {
        String s = "I use for hackerrank for programming";
        String t = "use for";
        String res[] = getMissing(s, t);

        for(String r: res)
            System.out.print(r);
    }

    private static String[] getMissing(String s, String t) {
        LinkedList<String> sS = new LinkedList<>();
        LinkedList<String> tS = new LinkedList<>();

        String S[] = s.split(" ");
        String T[] = t.split(" ");

        for(int i=0; i<S.length; i++)
            sS.add(S[i]);

        for(int i=0; i<T.length; i++)
            tS.add(T[i]);

        sS.removeAll(tS);
        return sS.toString().split(" ");

    }
}
