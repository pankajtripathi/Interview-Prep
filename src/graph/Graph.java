package com.practice.graph;

import java.util.*;

/**
 * Created by pankajtripathi on 11/10/16.
 */
public class Graph {
    int V;
    Map<String, List<String>> graph;
    Map<String, Boolean> visited;

    Graph(){
        graph = new HashMap<>();
        visited = new HashMap<>();
    }

    void addEdge(String s, String d){
        if(graph.containsKey(s))
            graph.get(s).add(d);
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

    void traverse(){
        for(Map.Entry<String , List<String >> entry: graph.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    Map<String, List<String >> getGraph(){
        return graph;
    }

    Map<String, Boolean> getVisited(){
        return visited;
    }

    public static void main(String[] args) {
        Graph obj = new Graph();
        obj.addEdge("A", "C");
        obj.addEdge("A", "B");
        obj.addEdge("B", "D");
        obj.addEdge("C", "D");
        obj.addEdge("C", "E");
        obj.addEdge("D", "E");
        obj.traverse();
    }
}
