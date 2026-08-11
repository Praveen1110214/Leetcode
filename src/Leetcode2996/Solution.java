package Leetcode2996;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6};
        System.out.println(new Solution().missingInteger(nums));
    }
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }
        boolean[] isPresent = new boolean[51];
        for(int num : nums){
            isPresent[num] = true;
        }
        for(int candidate = sum; ;candidate++) {
            if(candidate >= isPresent.length || !isPresent[candidate]){
                return candidate;
            }
        }
    }
}
