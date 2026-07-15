package Leetcode3558;

import java.util.ArrayList;
import java.util.List;

public class NoOfWaysToAssignEdgeWeightsI {
    static final int MOD = 1_000_000_007;
    static int maxDepth;
    public static void main(String[] args) {
        int[][] edges = {{1,2}};
        System.out.println(assignEdgeWeights(edges));
    }
    static int assignEdgeWeights(int[][] edges){
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(1, -1, 0, graph);
        if(maxDepth == 0){
            return 0;
        }
        return (int) power(2, maxDepth - 1);

    }
    static void dfs(int node, int parent, int depth, List<Integer>[] graph){
        maxDepth = Math.max(maxDepth, depth);
        for(int next : graph[node]){
            if(next != parent){
                dfs(next, node, depth + 1, graph);
            }
        }
    }
    static long power(long base, long exp){
        long result = 1;
        while(exp > 0){
            if((exp & 1) == 1){
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
