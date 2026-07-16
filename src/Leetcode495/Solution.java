package Leetcode495;

public class Solution {
    public static void main(String[] args) {
        int[] timeSeries = {1, 2};
        int duration = 2;
        System.out.println(new Solution().findPoisonedDuration(timeSeries, duration));
    }
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for(int i = 1; i < timeSeries.length; i++) {
            int gap = timeSeries[i] - timeSeries[i - 1];
            total += Math.min(duration, gap);
        }
        return total + duration;
    }
}