package com.practice.dp;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by pankajtripathi on 12/19/16.
 */
public class FordFulkerson {
    public static void main (String[] args) throws java.lang.Exception
    {
        // Let us create a graph shown in the above example
        int graph[][] =new int[][] { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println("The maximum possible flow is " + new FordFulkerson().fordFulkerson(graph, 0, 5));

    }

    private int fordFulkerson(int[][] graph, int s, int t) {
        int maxFlow = 0;
        int u, v;
        int[][] rGraph = new int[graph.length][graph[0].length];

        for (u = 0; u < rGraph.length; u++)
            for (v = 0; v < rGraph[0].length; v++)
                rGraph[u][v] = graph[u][v];
        int[] parent = new int[graph.length];

        while (bfs(rGraph, s, t, parent)){
            int flow = Integer.MAX_VALUE;

            //Get the min flow along the path which will be added to amx flow
            for (v = t; v!=s; v=parent[v]) {
                u = parent[v];
                flow = Math.min(flow, rGraph[u][v]);
            }

            // Update the residual graph
            for (v = t; v!=s ; v=parent[v]) {
                u = parent[v];
                rGraph[u][v] -= flow;
                rGraph[v][u] += flow;
            }
            maxFlow += flow;
        }
        return maxFlow;
    }

    private boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        boolean[] visited = new boolean[rGraph.length];
        for (int i = 0; i < visited.length; i++) visited[i] = false;

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (!q.isEmpty()){
            int u = q.poll();
            for (int v=0; v<rGraph.length; v++){
                if(visited[v] == false && rGraph[u][v] > 0){
                    parent[v] = u;
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        // return if sink node is reached
        return visited[t] == true;
    }
}
