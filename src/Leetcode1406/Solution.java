package Leetcode1406;

public class Solution {
    public static void main(String[] args) {
        int[] stoneValue = {1, 2, 3, 7};
        System.out.println(new Solution().stoneGameIII(stoneValue));
    }
    Integer[] dp;
    public String stoneGameIII(int[] stoneValue) {
        dp = new Integer[stoneValue.length];
        int diff = solve(stoneValue, 0);
        if(diff > 0) return "Alice";
        if(diff < 0) return "Bob";
        return "Tie";
    }
    private int solve(int[] stone, int i) {
        if(i >= stone.length) {
            return 0;
        }
        if(dp[i] != null) {
            return dp[i];
        }
        int best = Integer.MIN_VALUE;
        int sum = 0;
        for(int k = 0; k < 3 && i + k <stone.length; k++) {
            sum += stone[i + k];
            best = Math.max(best, sum - solve(stone, i + k + 1));
        }
        return dp[i] = best;
    }
}
