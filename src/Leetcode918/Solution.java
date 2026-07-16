package Leetcode918;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, -1, 1};
        System.out.println(new Solution().maxSubarraySumCircular(nums));
    }
    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = 0;
        int maxSum = nums[0];
        int currentMin = 0;
        int minSum = nums[0];
        int total = 0;
        for(int num : nums){
            currentMax = Math.max(num, currentMax + num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(num, currentMin + num);
            minSum = Math.min(minSum, currentMin);
            total += num;
        }
        if(maxSum < 0) return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}
