package Leetcode1344;

public class Solution {
    public static void main(String[] args) {
        int hour = 12;
        int minutes = 30;
        System.out.println(new Solution().angleClock(hour, minutes));
    }
    public double angleClock(int hour, int minutes){
        return Math.min((Math.abs((30 * hour) - (5.5 * minutes))),(360 - (Math.abs((30 * hour) - (5.5 * minutes)))));
    }
}
