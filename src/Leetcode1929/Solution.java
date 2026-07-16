package Leetcode1929;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(new Solution().getConcatenation(nums)));
    }
    public int[] getConcatenation(int[] nums){
        int n = nums.length;
        int[] ans = new int[2*n];
        for(int i = 0; i < ans.length; i++){
            ans[i] = nums[i % n];
        }
        return ans;
    }
}
