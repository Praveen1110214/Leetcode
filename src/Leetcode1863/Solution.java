package Leetcode1863;

public class Solution {
    int sum = 0;
    public static void main(String[] args) {
        int[] nums = {1, 3};
        Solution sol = new Solution();
        System.out.println(sol.subsetXORSum(nums));
    }
    public int subsetXORSum(int[] nums){
        backTrack(nums,0,0);
        return sum;
    }
    private void backTrack(int[] nums, int index, int xor){
        if(index == nums.length){
            sum += xor;
            return;
        }
        backTrack(nums, index + 1, xor);
        backTrack(nums, index + 1, xor ^ nums[index]);
    }
}
