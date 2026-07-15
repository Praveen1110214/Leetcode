package Leetcode96;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().numTrees(n));
    }
    public int numTrees(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int nodes = 2; nodes <= n; nodes++){
            for(int root = 1; root <= nodes; root++){
                int left = root - 1;
                int right = nodes - root;
                dp[nodes] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
