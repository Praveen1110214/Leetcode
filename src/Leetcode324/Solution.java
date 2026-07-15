package Leetcode324;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,6,1,5,4,1};
        new Solution().wiggleSort(nums);
    }
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int n = nums.length;
        int left = (n - 1) / 2;
        int right = n - 1;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0) {
                nums[i] = sorted[left];
                left--;
            } else {
                nums[i] = sorted[right];
                right--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
