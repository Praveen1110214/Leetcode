package Leetcode268;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println(new Solution().missingNumber2(nums));
    }
    public int missingNumber(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }
        int[] arr = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                return i;
            }
        }
        return max + 1;
    }
    public int missingNumber2(int[] nums) {
        int n = nums.length;

        int total = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return total - sum;
    }
}
