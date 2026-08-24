package Leetcode1872;

public class Solution {
    public static void main(String[] args) {

    }
    private Integer[] memo;
    private int[] prefixSum;
    private int n;
    public int stoneGameVIII(int[] stones) {
        n = stones.length;
        memo = new Integer[n];
        for(int i = 1; i < stones.length; i++) {
            stones[i] += stones[i - 1];
        }
        prefixSum = stones;
        return dfs(1);
    }
    private int dfs(int currentIndex){
        if(currentIndex >= n - 1) {
            return prefixSum[currentIndex];
        }
        if(memo[currentIndex] == null) {
            int skipCurrent = dfs(currentIndex + 1);
            int takeCurrent = prefixSum[currentIndex] - dfs(currentIndex + 1);
            memo[currentIndex] = Math.max(skipCurrent, takeCurrent);
        }
        return memo[currentIndex];
    }
}
