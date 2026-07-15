package Leetcode2778;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new Solution().sumOfSquares(nums));
    }
    public int sumOfSquares(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums.length % (i + 1) == 0) {
                result += (nums[i] * nums[i]);
            }
        }
        return result;
    }
}
