package Leetcode1103;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int candies = 7;
        int num_people = 4;
        System.out.println(Arrays.toString(new Solution().distributeCandies(candies, num_people)));
    }
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int give = 1;
        int i = 0;
        while (candies > 0) {
            int index = i % num_people;
            int currentGive = Math.min(give, candies);
            ans[index] += currentGive;
            candies -= currentGive;
            give++;
            i++;
        }
        return ans;
    }
}