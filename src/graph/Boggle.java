package com.practice.graph;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by pankajtripathi on 11/11/16.
 */
public class Boggle {
    Set<String> words = new TreeSet<>();
    public static void main(String[] args) {
        Boggle b = new Boggle();

        b.words.add("GEEKS");
        b.words.add("GO");
        b.words.add("QUIZ");

        char graph[][] = {
                {'G','I','Z'},
                {'U','E','K'},
                {'Q','S','E'}

        };
        b.getWords(graph);
    }

    private void getWords(char[][] graph) {
        int M = graph.length;
        int N = graph[0].length;

        boolean visited[][] = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) dfs(graph, visited, i, j, "");
            }
        }
    }

    private void dfs(char[][] graph, boolean[][] visited, int i, int j, String str) {
        visited[i][j] = true;
        str += graph[i][j];

        if(words.contains(str)) System.out.println(str);
        for (int row = i-1; row <= i+1 && row < graph.length; row++) {
            for (int col = j-1; col<=j+1 && col < graph[0].length; col++) {
                if(row >= 0 && col >= 0 && !visited[row][col]) dfs(graph, visited, row, col, str);
            }
        }
        visited[i][j] = false;
    }
}
