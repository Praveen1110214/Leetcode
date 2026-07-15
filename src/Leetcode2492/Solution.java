package Leetcode2492;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {

    }
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            int city1 = road[0];
            int city2 = road[1];
            int distance = road[2];
            adj.get(city1).add(new int[]{city2, distance});
            adj.get(city2).add(new int[]{city1, distance});
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        int minScore = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int city = queue.poll();
            for(int[] edge : adj.get(city)){
                int neighbor = edge[0];
                int distance = edge[1];
                minScore = Math.min(minScore, distance);
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        return minScore;
    }
}
