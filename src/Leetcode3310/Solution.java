package Leetcode3310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int k = 1;
        int[][] invocations = {{1, 2}, {0, 1}, {3 ,2}};
        System.out.println(new Solution().remainingMethods(n, k, invocations));
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : invocations) {
            graph[edge[0]].add(edge[1]);
        }
        System.out.println(Arrays.toString(graph));
        boolean[] suspicious = new boolean[n];
        dfs(k, graph, suspicious);
        System.out.println(Arrays.toString(suspicious));
        for(int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            if(!suspicious[u] && suspicious[v]) {
                List<Integer> ans = new ArrayList<>();
                for(int i = 0; i < n; i++) {
                    ans.add(i);
                }
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(!suspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
    public void dfs(int node, List<Integer>[] graph, boolean[] suspicious) {
        suspicious[node] = true;
        for(int next : graph[node]) {
            if(!suspicious[next]){
                dfs(next, graph, suspicious);
            }
        }
    }
}
