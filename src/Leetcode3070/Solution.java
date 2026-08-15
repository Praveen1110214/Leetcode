package Leetcode3070;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().longestSubsequence(nums));
    }
    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        int zero = 0;
        int n = nums.length;
        for(int num : nums){
            totalXor ^= num;
            if(num == 0) zero++;
        }
        if(totalXor != 0) return n;
        return zero == n ? 0 : n - 1;
    }
}
