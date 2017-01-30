package com.practice.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pankajtripathi on 11/12/16.
 */
public class Bipartite {

    public static void main(String args[]){
        Bipartite b = new Bipartite();
        int graph[][] = {{0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        b.isBipartite(graph, 0);
    }

    private void isBipartite(int[][] graph, int src) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) color[i] = -1;

        q.add(src);
        color[src] = 1;

        while(!q.isEmpty()){
            int u = q.poll();
            for(int v = 0; v < graph.length; v++){
                if(graph[u][v] == 1 && color[v] == -1){
                    color[v] = 1 - color[u];
                    q.add(v);
                }
                else if(graph[u][v] == 1 && color[u] == color[v])
                    System.out.println("Not Bipartite");
            }
        }
        System.out.println("Is Bipartite");
    }
}
