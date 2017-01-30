package com.practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pankajtripathi on 11/10/16.
 */
public class CycleInDG {
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
        CycleInDG obj = new CycleInDG();
        graph = new HashMap<>();
        visited = new HashMap<>();
        cycleStack = new HashMap<>();
        hasCycle = false;

        obj.addEdge("0", "1");
        obj.addEdge("0", "2");
        obj.addEdge("1", "2");
        obj.addEdge("2", "0");
        obj.addEdge("2", "3");
        obj.addEdge("3", "3");
        obj.detectCycle("2");

        if(hasCycle)
            System.out.println("Cyclic");
        else
            System.out.println("Acyclic");

        CycleInDG obj2 = new CycleInDG();
        graph = new HashMap<>();
        visited = new HashMap<>();
        cycleStack = new HashMap<>();
        hasCycle = false;

        obj2.addEdge("0", "1");
        obj2.addEdge("1", "2");
        obj2.detectCycle("0");

        if(hasCycle)
            System.out.println("Cyclic");
        else
            System.out.println("Acyclic");

    }

    private void detectCycle(String u) {
        visited.put(u, true);
        cycleStack.put(u, true);

        for(String v: graph.get(u)){
            if(!visited.get(v))
                detectCycle(v);
            else if(cycleStack.get(v)){
                hasCycle = true;
                break;
            }
        }
        cycleStack.put(u, false);
    }
}
