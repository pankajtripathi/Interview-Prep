package com.practice.graph;

/**
 * Created by pankajtripathi on 11/12/16.
 */
public class ConnectedComponent {
    public int find(int parent[], int i){
        if(parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    /*
    public void union(int parent[], int x, int y){
        int xp = find(parent, x);
        int yp = find(parent, y);
        parent[xp] = yp;
    }
    */

    public int connectedComp(int n, int[][] edges){
        int[] parent = new int[n];
        int count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int edge[]: edges){
            int x = edge[0];
            int y = edge[1];

            int xp = find(parent, x);
            int yp = find(parent, y);

            if(xp != yp)
                count--;
            parent[xp] = yp;
        }

        return count;
    }

    public static void main(String[] args) {
        ConnectedComponent obj = new ConnectedComponent();
        int edges[][] = {
                {0, 1},
                {1, 2},
                {3, 4},
                {2, 3}
        };
        System.out.println(obj.connectedComp(5, edges));
    }
}
