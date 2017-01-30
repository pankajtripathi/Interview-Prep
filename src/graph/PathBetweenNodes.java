package com.practice.graph;

import com.practice.strings.StringToInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by pankajtripathi on 11/10/16.
 */
public class PathBetweenNodes {
    static Map<String , List<String>> graph;
    static Map<String , Boolean> visited;
    static List<String> paths = new ArrayList<>();

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

        displayPaths("0", "2", getPaths("0", "2"));
    }

    private static void displayPaths(String src, String dest, List<String> paths) {
        System.out.println("Paths to travel from " + src + " to " + dest + " are: " );
        for(String path: paths){
            for(char c: path.toCharArray())
                System.out.print(c + " ");
        }
    }

    private static List<String> getPaths(String src, String dest) {
        return dfs(src, dest, "");
    }

    private static List<String> dfs(String src, String dest, String res) {
        visited.put(src, true);
        res += src;

        if(src == dest) paths.add(res);
        else{
            for (String v: graph.get(src)){
                if(!visited.get(v)) dfs(v, dest, res);
            }
        }
        return paths;
    }
}
