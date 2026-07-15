package Leetcode152;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(new Solution().maxProduct(nums));
    }
    public int maxProduct(int[] nums){
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tempMax = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(tempMax * nums[i], min * nums[i]));
            ans = Math.max(ans, max);
        }
        return ans;
    }
}