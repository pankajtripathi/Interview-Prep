package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pankajtripathi on 11/10/16.
 */
public class CycleInUDG {
    static Map<String , List<String>> graph;
    static Map<String , Boolean> visited;
    static Map<String , Boolean> cycleStack;
    static boolean hasCycle;

    public static void addEdge(String s, String d){
        if(graph.containsKey(s)){
            List<String> edges = graph.get(s);
            edges.add(d);
        }
        else{
            List<String> edge = new ArrayList<>();
            edge.add(d);
            graph.put(s,edge);
            visited.put(s, false);
        }

        // Need to add this extra code in directed graph for end node. Example 0->1, 1->2 in this case since 2 won't be
        // in the graph we will get NullPointerException so add destination as well
        if(!graph.containsKey(d)){
            graph.put(d, new ArrayList<>());
            visited.put(d, false);
        }

    }

    public static void main(String[] args) {
        CycleInUDG obj = new CycleInUDG();
        graph = new HashMap<>();
        visited = new HashMap<>();
        cycleStack = new HashMap<>();

        obj.addEdge("1", "0");
        obj.addEdge("0", "2");
        obj.addEdge("2", "0");
        obj.addEdge("0", "3");
        obj.addEdge("3", "4");
        if(obj.isCyclic())
            System.out.println("Cyclic");
        else System.out.println("Acyclic");


        CycleInUDG obj2 = new CycleInUDG();
        graph = new HashMap<>();
        visited = new HashMap<>();
        cycleStack = new HashMap<>();

        obj2.addEdge("0", "1");
        obj2.addEdge("1", "2");
        if(obj2.isCyclic())
            System.out.println("Cyclic");
        else System.out.println("Acyclic");
    }

    private boolean isCyclic() {
        for(Map.Entry<String, List<String>> entry:graph.entrySet()){
            if(detectCycle(entry.getKey(), "-1")) return true;
        }
        return false;
    }

    private static boolean detectCycle(String u, String p) {
        visited.put(u, true);

        for(String v:graph.get(u)){
            if(!visited.get(v))
                if(detectCycle(v, u)) return true;
            else if(v != p)
                return true;
        }
        return false;
    }
}
