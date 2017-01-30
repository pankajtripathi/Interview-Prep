package com.practice.graph;

/**
 * Created by pankajtripathi on 11/15/16.
 */

/*
* Similar to course schedule problem.
* Create a graph then do topological sort on it by checking if there exists a cycle.
* To create a graph take two words then compare them if there is mismatch then add letter1 in graph with edge between
* letter1 and letter2
* */
import java.util.*;

public class AlienDictionary {
    Map<Character , Set<Character>> graph =  new HashMap<>();
    Stack<Character> st = new Stack<>();

    public static void main(String[] args) {
        String arr[] = new String[]{"z", "z"};
        String str = new AlienDictionary().alienOrder(arr);
        System.out.println(str);
    }

    private String alienOrder(String[] words) {
        String res = "";
        for(int i=0; i<words.length-1; i++){
            String w1 = words[i], w2 = words[i+1];
            int len = Math.min(w1.length(),w2.length());

            for(int j=0; j<len; j++){
                char c1 = w1.charAt(j), c2 = w2.charAt(j);
                if(!graph.containsKey(c1)) graph.put(c1, new HashSet<>());
                if(!graph.containsKey(c2)) graph.put(c2, new HashSet<>());
                if(c1 != c2){
                    graph.get(c1).add(c2);
                }
            }
        }

        int visited[] = new int[256];
        for(Map.Entry<Character, Set<Character>> entry: graph.entrySet()){
            if(!dfs(entry.getKey(), visited)) return "";
        }
        while (!st.isEmpty()) res += st.pop();
        return res;
    }

    private boolean dfs(Character u, int[] visited){
        if(visited[u-'a']==-1) return false;
        if(visited[u-'a']==1) return true;

        visited[u-'a'] = -1;
        if(graph.containsKey(u)){
            for(Character v:graph.get(u))
                if(!dfs(v, visited)) return false;
        }

        visited[u-'a'] = 1;
        st.push(u);
        return true;
    }
}
