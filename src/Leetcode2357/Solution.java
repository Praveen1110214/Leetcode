package Leetcode2357;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Solution().minimumOperations(nums));
    }
    public int minimumOperations(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
