package Leetcode3532;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        int[] nums = {2, 5, 6, 8};
        int maxDiff = 2;
        int[][] queries = {{0,1}, {0,2}, {1,3}, {2,3}};
        System.out.println(Arrays.toString(new Solution().pathExistenceQueries(n, nums, maxDiff, queries)));
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int[] component = new int[n];
        component[0] = 0;
        for(int i = 1; i < n; i++){
            if(Math.abs(nums[i] - nums[i - 1]) <= maxDiff){
                component[i] = component[i - 1];
            } else {
                component[i] = component[i - 1] + 1;
            }
        }
        for(int i = 0; i < queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            res[i] = component[u] == component[v];
        }
        return res;
    }
}
