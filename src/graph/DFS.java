package com.practice.graph;

import java.util.List;
import java.util.Map;

/**
 * Created by pankajtripathi on 11/10/16.
 */
public class DFS {
    static Map<String , List<String>> graph;
    static Map<String , Boolean> visited;

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("0", "1");
        g.addEdge("0", "2");
        g.addEdge("1", "2");
        g.addEdge("2", "0");
        g.addEdge("2", "3");
        g.addEdge("3", "3");
        graph = g.getGraph();
        visited = g.getVisited();

        DFS obj = new DFS();
        obj.dfs("2");
    }

    private void dfs(String u) {
        visited.put(u, true);
        System.out.print(u + " ");

        for (String v: graph.get(u)){
            if (visited.get(v) == false)
                dfs(v);
        }
    }
}
