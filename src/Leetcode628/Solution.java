package Leetcode628;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, -7, -8, 9};
        System.out.println(new Solution().maximumProduct(nums));
    }
    public int maximumProduct(int[] nums) {
        if(nums.length == 3) return nums[0] * nums[1] * nums[2];
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                third = second;
                second = nums[i];
            } else if(nums[i] > third){
                third = nums[i];
            }
            if(nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return Math.max(first * second * third, first * min2 * min1);
    }
}
