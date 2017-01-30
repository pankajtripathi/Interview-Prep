package com.practice.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by pankajtripathi on 11/10/16.
 */
public class BFS {
    static Map<String , List<String>> graph;
    static Map<String , Boolean> visited;
    static Queue<String> queue = new LinkedList<>();

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

        BFS obj = new BFS();
        obj.bfs("2");
    }

    private void bfs(String s) {
        visited.put(s, true);
        queue.add(s);

        while(!queue.isEmpty()){
            String u = queue.poll();
            System.out.print(u + " ");

            for(String v: graph.get(u)){
                if(!visited.get(v)) {
                    visited.put(v, true);
                    queue.add(v);
                }
            }
        }
    }


}
