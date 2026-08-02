package Leetcode877;

public class Solution {
    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(new Solution().stoneGame2(piles));
    }
    public boolean stoneGame(int[] piles) {
        return true;
    }
    Integer[][] dp;
    public boolean stoneGame2(int[] piles) {
        int n = piles.length;
        dp = new Integer[n][n];
        return solve(piles, 0, n - 1) > 0;
    }
    private int solve(int[] piles, int i, int j) {
        if(i == j) {
            return piles[i];
        }
        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int left = piles[i] - solve(piles, i + 1, j);
        int right = piles[j] - solve(piles, i, j - 1);
        return dp[i][j] = Math.max(left, right);
    }
}