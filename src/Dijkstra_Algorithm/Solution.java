package Dijkstra_Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public List<Integer> dijkstra(List<List<int[]>> adj, int src){
        int V = adj.size();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        priorityQueue.offer(new int[]{0, src});
        while(!priorityQueue.isEmpty()){
            int[] top = priorityQueue.poll();
            int d = top[0];
            int u = top[1];
            if(d > dist[u]) continue;
            for(int[] p : adj.get(u)){
                int v = p[0];
                int w = p[1];
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    priorityQueue.offer(new int[]{dist[v], v});
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int d : dist){
            result.add(d);
        }
        return result;
    }
}
