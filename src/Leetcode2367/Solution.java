package Leetcode2367;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0,1,4,6,7,10};
        int diff = 3;
        System.out.println(new Solution().arithmeticTriplets1(nums, diff));
    }
    public int arithmeticTriplets(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i] + diff) && set.contains(nums[i] - diff)) count++;
        }
        return count;
    }
    public int arithmeticTriplets1(int[] nums, int diff) {
        boolean[] present = new boolean[201];
        for(int num : nums) present[num] = true;
        int count = 0;
        for(int num : nums) {
            if(num + diff <= 200 && present[num + diff] && num + 2 * diff <= 200 && present[num + 2 * diff]){
                count++;
            }
        }
        return count;
    }
}
