package Leetcode3312;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4};
        long[] queries = {0, 2, 2};
        System.out.println(Arrays.toString(new Solution().gcdValues(nums, queries)));
    }
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);
        // Frequency of each number
        int[] freq = new int[max + 1];
        for (int x : nums)
            freq[x]++;
        // exact[g] = number of pairs whose gcd is exactly g
        long[] exact = new long[max + 1];
        // Compute from largest gcd to smallest
        for (int g = max; g >= 1; g--) {
            long count = 0;
            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                count += freq[multiple];
            }
            // Total pairs divisible by g
            exact[g] = count * (count - 1) / 2;
            // Remove pairs already counted for larger gcds
            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }
        // Prefix sums
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long target = queries[i] + 1;
            int left = 1;
            int right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (prefix[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }
            ans[i] = left;
        }
        return ans;
    }
}
