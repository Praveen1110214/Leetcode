package Leetcode338;

import java.util.Arrays;

public class CountingBits {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(countBits(n)));
    }
    static int[] countBits(int n){
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
