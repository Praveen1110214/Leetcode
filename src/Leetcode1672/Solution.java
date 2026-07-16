package Leetcode1672;

public class Solution {
    public static void main(String[] args) {
        int[][] accounts = {
                {1,2,3},
                {3,2,1}
        };
        System.out.println(new Solution().maximumWealth(accounts));
    }
    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for(int[] account : accounts){
            int sum = 0;
            for(int amount : account){
                sum += amount;
                max = Math.max(sum, max);
            }
        }
        return max;
    }
}
