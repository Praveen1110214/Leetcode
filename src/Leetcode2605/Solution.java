package Leetcode2605;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums1 = {3,5,2,6};
        int[] nums2 = {3,1,7};
        System.out.println(new Solution().minNumber1(nums1, nums2));
    }
    public int minNumber(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1) {
            set1.add(num);
        }
        for(int num : nums2) {
            set2.add(num);
        }
        for(int num : set1) {
            if(set2.contains(num)) {
                min = Math.min(min, num);
            }
        }
        if(min == Integer.MAX_VALUE){
            int min1 = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;
            for(int num : set1) {
                min1 = Math.min(min1, num);
            }
            for(int num : set2) {
                min2 = Math.min(min2, num);
            }
            if(10 * min1 + min2 < 10 * min2 + min1) {
                return 10 * min1 + min2;
            }else {
                return 10 * min2 + min1;
            }
        }
        return min;
    }
    public int minNumber1(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[10];
        int min1 = 10;
        int min2 = 10;
        for(int num : nums1) {
            seen[num] = true;
            min1 = Math.min(min1, num);
        }
        int common = 10;
        for(int num : nums2) {
            min2 = Math.min(num, min2);
            if(seen[num]) {
                common = Math.min(common, num);
            }
        }
        if(common != 10) return common;
        return Math.min(10 * min1 + min2, 10 * min2 + min1);
    }
}
