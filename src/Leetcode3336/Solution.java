package Leetcode3336;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution().subsequencePairCount(nums));
    }
    int MOD = 1_000_000_007;
    Integer[][][] dp;
    public int subsequencePairCount(int[] nums) {
        dp = new Integer[nums.length][201][201];
        return dfs(0,0,0,nums);
    }
    private int dfs(int index, int g1, int g2, int[] nums){
        if(index == nums.length) return (g1 == g2 && g1 != 0) ? 1 : 0;
        if(dp[index][g1][g2] != null) return dp[index][g1][g2];
        int ans = 0;
        ans = (ans + dfs(index + 1, g1, g2, nums)) % MOD;
        int newG1 = (g1 == 0) ? nums[index] : gcd(g1, nums[index]);
        ans = (ans + dfs(index + 1, newG1, g2, nums)) % MOD;
        int newG2 = (g2 == 0) ? nums[index] : gcd(g2, nums[index]);
        ans = (ans + dfs(index + 1, g1, newG2, nums)) % MOD;
        return dp[index][g1][g2] = ans;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
