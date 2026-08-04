package Leetcode3731;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 8, 7};
        System.out.println(new Solution().findMissingElements(nums));
    }
    public List<Integer> findMissingElements(int[] nums) {
       int min = 100;
       int max = 0;
       Set<Integer> set = new HashSet<>();
       for(int num : nums) {
           min = Math.min(min, num);
           max = Math.max(max, num);
           set.add(num);
       }
       List<Integer> ans = new ArrayList<>();
       for(int i = min + 1; i < max; i++) {
           if(!set.contains(i)) {
               ans.add(i);
           }
       }
       return ans;
    }
}
