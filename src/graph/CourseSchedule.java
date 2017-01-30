package com.practice.graph;

import java.util.*;

/**
 * Created by pankajtripathi on 11/11/16.
 */
public class CourseSchedule {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    int index;

    public static void main(String[] args) {
        int pre[][] = {{1, 0}};
        int a[] = new CourseSchedule().canFinish(2, pre);
        for (int i: a)
            System.out.print(i +" ");
    }

    public  int[] canFinish(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        index = numCourses-1;
        if(numCourses <= 0) return new int[0];
        if(prerequisites.length == 0){
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
        }

        for(int a[]: prerequisites){
            if(graph.containsKey(a[1]))
                graph.get(a[1]).add(a[0]);
            else {
                List<Integer> preList = new ArrayList<>();
                preList.add(a[0]);
                graph.put(a[1], preList);
            }
        }

        int visited[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(i, visited, res)) return  new int[0];
        }
        return res;
    }

    private boolean dfs(Integer u, int[] visited, int res[]){
        if(visited[u] == -1) return false;
        if(visited[u] == 1) return true;

        visited[u] = -1;
        if(graph.containsKey(u)){
            for (Integer v: graph.get(u)){
                if (!dfs(v, visited, res)) return false;
            }
        }
        visited[u] = 1;
        res[index--] = u;
        return true;
    }
}
