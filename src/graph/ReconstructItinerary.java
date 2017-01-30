package com.practice.graph;

/**
 * Created by pankajtripathi on 11/16/16.
 */
/*
* Trip should start from JFK
* */

import java.util.*;

public class ReconstructItinerary {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    LinkedList<String> res = new LinkedList<>();

    public static void main(String[] args) {
        String tickets[][] = {
                {"MUC", "LHR"},
                {"JFK", "MUC"},
                {"SFO", "SJC"},
                {"LHR", "SFO"}
        };
        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }

    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket: tickets){
            if(!map.containsKey(ticket[0])){
                PriorityQueue<String> q = new PriorityQueue<>();
                q.add(ticket[1]);
                map.put(ticket[0], q);
            }
            else
                map.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK");
        return res;
    }

    private void dfs(String src) {
        PriorityQueue<String> next = map.get(src);
        while(next != null && !next.isEmpty()){
            dfs(next.poll());
        }
        res.addFirst(src);
    }
}
