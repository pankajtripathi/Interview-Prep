package com.practice.graph;

import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by pankajtripathi on 11/10/16.
 */
public class TopologicalSorting {
    static Map<String , List<String>> graph;
    static Map<String , Boolean> visited;
    static Stack<String> st = new Stack<>();

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("5", "2");
        g.addEdge("5", "0");
        g.addEdge("4", "0");
        g.addEdge("4", "1");
        g.addEdge("2", "3");
        g.addEdge("3", "1");
        graph = g.getGraph();
        visited = g.getVisited();

        new TopologicalSorting().sort();
    }

    private void dfs(String u){
        visited.put(u, false);

        for(String v: graph.get(u)){
            if(!visited.get(v)) dfs(v);
        }
        visited.put(u, true);
        st.push(u);
    }

    private void sort() {
        for(Map.Entry<String, List<String>> entry: graph.entrySet()){
            if(!visited.get(entry.getKey())) dfs(entry.getKey());
        }
        while(!st.isEmpty()) System.out.print(st.pop() + " ");
    }
}
