package com.practice.graph;

/**
 * Created by pankajtripathi on 11/11/16.
 */
import java.util.*;

public class MinHeightTree {
    public static void main(String[] args) {
        int edges[][] = {
                {1,0},
                {1,2},
                {1,3}
        };
        System.out.println(new MinHeightTree().findMinHeightTrees(4, edges));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Create a graph
        List<Integer> leaves = new LinkedList<>();
        if(n==0) return new ArrayList<>();
        if(n==1){
            leaves.add(0);
            return leaves;
        }

        //graph
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new HashSet<>());
        for (int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //get leaves
        for (int i = 0; i < n; i++) {
            if(graph.get(i).size() == 1) leaves.add(i);
        }

        while(n>2){
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();
            // get the neighbor of each leaf and then from the graph of neighbor remove the leaf and add it to leaves.
            for(int l: leaves){
                int neighbor = graph.get(l).iterator().next();
                graph.get(neighbor).remove(l);
                if(graph.get(neighbor).size() == 1) newLeaves.add(neighbor);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
