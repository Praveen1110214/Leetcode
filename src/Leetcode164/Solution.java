package Leetcode164;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(new Solution().maximumGap(nums));
    }
    public int maximumGap(int[] nums){
        if(nums.length < 2) return 0;
        Arrays.sort(nums);
        int maxDiff = nums[1] - nums[0];
        for(int i = 1; i < nums.length; i++){
            maxDiff = Math.max(maxDiff, nums[i + 1] - nums[i]);
        }
        return maxDiff;
    }
}
