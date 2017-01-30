package com.practice.graph;

/**
 * Created by pankajtripathi on 11/17/16.
 */
public class Prim {
    public static void main(String[] args) {
        int graph[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        new Prim().primMST(graph);
    }

    private int minKey(int[] key, boolean[] mst){
        int minVal = Integer.MAX_VALUE, minIndex = -1;
        for (int i = 0; i < key.length; i++) {
            if(mst[i] == false && key[i] < minVal){
                minVal = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private void primMST(int[][] graph) {
        boolean mst[] = new boolean[graph.length];  // To represent set of vertices not yet included in MST
        int[] parent = new int[graph.length]; // Array to store constructed MST
        int[] key = new int[graph.length];  // Key values used to pick minimum weight edge in cut


        // Initialize the key values with infinity and mst to false
        for(int i=0; i < graph.length; i++){
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }

        // Put the first key value as 0 so it shallbe picked first and it's parent would be -1
        key[0] = 0;
        parent[0] = -1;

        // Build MST for all vertices
        for (int i = 0; i < graph.length; i++) {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in MST
            int u = minKey(key, mst);
            mst[u] = true;

            for (int v = 0; v < graph.length; v++) {
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if(graph[u][v] != 0 && mst[v] == false && graph[u][v] < key[v]){
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }

        }
        printMST(graph, parent);
    }

    private void printMST(int[][] graph, int[] parent) {
        for (int i = 1; i < parent.length; i++) {
            System.out.println(parent[i] + " - " + i + "   " + graph[parent[i]][i]);
        }
    }
}
