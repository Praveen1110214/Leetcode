package Leetcode169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 1};
        System.out.println(new Solution().majorityElement(nums));
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > (nums.length / 2)){
                result = entry.getKey();
                break;
            }
        }
        return result;
    }
}
