package Leetcode136;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 5};
        System.out.println(new Solution().singleNumber(nums));
    }
    public int singleNumber(int[] nums){
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
