package Leetcode3513;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(new Solution().uniqueXorTriplets(nums));
    }
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n < 3) return n;
        int k = 31 - Integer.numberOfLeadingZeros(n);
        return 1 << (k + 1);
    }
}
