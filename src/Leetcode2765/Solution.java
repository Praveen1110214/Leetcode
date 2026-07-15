package Leetcode2765;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,3,4,3,4};
        System.out.println(new Solution().alternatingSubarray(nums));
    }
    public int alternatingSubarray(int[] nums) {
       int n = nums.length;
       int ans = -1;
       for(int i = 0; i < n - 1; i++) {
           if(nums[i + 1] - nums[i] != 1) {
               continue;
           }
           int len = 2;
           int expected = -1;
           for(int j = i + 1; j < n - 1; j++) {
               if(nums[j + 1] - nums[j] == expected) {
                   len++;
                   expected *= -1;
               } else {
                   break;
               }
           }
           ans = Math.max(ans, len);
       }
       return ans;
    }
}
