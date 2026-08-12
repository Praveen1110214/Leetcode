package Leetcode2958;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2};
        int k = 2;
        System.out.println(new Solution().maxSubarrayLength(nums, k));
    }
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        for(int right = 0; right < nums.length; right++) {
            freq.merge(nums[right], 1, Integer::sum);
            while(freq.get(nums[right]) > k) {
                freq.merge(nums[left], -1, Integer::sum);
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
