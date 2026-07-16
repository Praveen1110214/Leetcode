package Leetcode1288;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 6}, {2, 8}};
        System.out.println(new Solution().removeCoveredIntervals(intervals));
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        int total = intervals.length;
        int maxEnd = 0;
        for(int[] interval : intervals){
            if(interval[1] <= maxEnd){
                total--;
            } else {
                maxEnd = interval[1];
            }
        }
        return total;
    }
}
