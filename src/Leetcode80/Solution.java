package Leetcode80;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3 ,3 ,3};
        System.out.println(new Solution().removeDuplicates(nums));
    }
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int write = 2;

        for (int i = 2; i < nums.length; i++) {

            if (nums[i] != nums[write - 2]) {
                nums[write] = nums[i];
                write++;
            }

        }

        return write;
    }
}
