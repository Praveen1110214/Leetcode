package Leetcode2685;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    boolean[] visited;
    int edges;
    int nodes;
    public int countCompleteComponents(int n, int[][] edgesArray) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edgesArray) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        visited = new boolean[n];
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                nodes = 0;
                edges = 0;
                dfs(i, graph);
                edges /= 2;
                if(edges == nodes * (nodes - 1) / 2 ){
                    answer++;
                }
            }
        }
        return answer;
    }
    private void dfs(int node, List<Integer>[] graph){
        visited[node] = true;
        nodes++;
        edges += graph[node].size();
        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next, graph);
            }
        }
    }
}
