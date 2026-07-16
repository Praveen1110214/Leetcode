package Leetcode3867;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 8};
        System.out.println(new Solution().gcdSum(nums));
    }
    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int mx = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > mx){
                mx = nums[i];
            }
            prefixGcd[i] = gcd(nums[i], mx);
        }
        Arrays.sort(prefixGcd);
        int left = 0;
        int right = prefixGcd.length - 1;
        long sum = 0;
        while(left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

}
