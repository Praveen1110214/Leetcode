package Leetcode1140;

public class Solution {
    public static void main(String[] args) {

    }
    private int[][] dp;
    private int[] suffix;
    private int n;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n + 1];
        suffix = new int[n + 1];
        for(int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        return solve(0, 1);
    }
    private int solve(int i, int M) {
        if(i >= n) return 0;
        if(2 * M >= n - i) return suffix[i];
        if(dp[i][M] != 0) return dp[i][M];
        int maxStones = 0;
        for(int X = 1; X <= 2 * M; X++) {
            int newIndex = i + X;
            int newM = Math.max(M,X);
            int opponent = solve(newIndex, newM);
            int currentPlayer = suffix[i] - opponent;
            maxStones = Math.max(maxStones, currentPlayer);
        }
        dp[i][M] = maxStones;
        return maxStones;
    }
}
