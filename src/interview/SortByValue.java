package com.practice.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by pankajtripathi on 12/20/16.
 */
public class SortByValue {
    public static void main(String[] args) {
        String[][] det = {
                {"1000", "3"},
                {"1001", "3.5"},
                {"1002", "2"},
                {"1003", "3"}
        };
        System.out.println(new SortByValue().sort(det));
    }

    private Map<String, Double> sort(String[][] det){
        HashMap<String, Double> map = new HashMap<>();
        //MyComparator mc = new MyComparator(map);
        TreeMap<String, Double> tm = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) >= map.get(o2))
                    return 1;
                else return -1;
            }
        });

        for(String[] s:det)
            map.put(s[0], new Double(s[1]));

        tm.putAll(map);
        return tm;
    }
}

/*
class MyComparator implements Comparator<String>{
    Map<String, Double> base;
    MyComparator(Map<String, Double> base){
        this.base = base;
    }
    @Override
    public int compare(String k1, String k2) {
        if(base.get(k1) <= base.get(k2))
            return 1;
        else return -1;
    }
}
*/
