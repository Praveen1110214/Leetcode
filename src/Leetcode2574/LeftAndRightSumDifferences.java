package Leetcode2574;

import java.util.Arrays;

public class LeftAndRightSumDifferences {
    public static void main(String[] args) {
        int[] nums = {10,4,8,3};
        System.out.println(Arrays.toString(leftRightDifference(nums)));
    }
    static int[] leftRightDifference(int[] nums){
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for(int i = 1; i <= n; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int totalSum = prefixSum[n];
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = Math.abs(prefixSum[i] - (totalSum - prefixSum[i + 1]));
        }
        return result;
    }
}
