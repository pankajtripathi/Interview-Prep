package com.practice.graph;

/**
 * Created by pankajtripathi on 11/17/16.
 */
public class FloydWarshal {
    private final static int INF = 999;
    public static void main(String[] args) {
        int[][] graph = {
                {0, 5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };
        floydWarshal(graph);
    }

    private static void floydWarshal(int[][] graph) {
        int[][] dist = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if(dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        printPaths(dist);
    }

    private static void printPaths(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                System.out.print(dist[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
