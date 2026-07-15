package Leetcode1732;

public class Solution {
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};

        System.out.println(new Solution().largestAltitude(gain));
    }
    public int largestAltitude(int[] gain){
        int max = 0;
        int prefixSum = 0;
        for(int num : gain){
            prefixSum += num;
            max = Math.max(max, prefixSum);
        }
        return max;
    }
}
