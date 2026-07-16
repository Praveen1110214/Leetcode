package Leetcode2437;

public class Solution {
    public static void main(String[] args) {
        String time = "??:??";
        System.out.println(new Solution().countTime(time));
    }
    public int countTime(String time) {
        int count = 1;
        if(time.charAt(0) == '?' && time.charAt(1) == '?') {
            count *= 24;
        } else if(time.charAt(0) == '?') {
            if(time.charAt(1) < '4') {
                count *= 3;
            } else {
                count *= 2;
            }
        } else if(time.charAt(1) == '?') {
            if(time.charAt(0) < '2') {
                count *= 10;
            } else if(time.charAt(0) == '2') {
                count *= 4;
            }
        }
        if(time.charAt(3) == '?' && time.charAt(4) == '?') {
            count *= 60;
        } else if (time.charAt(3) == '?') {
            count *= 6;
        } else if (time.charAt(4) == '?'){
            count *= 10;
        }
        return count;
    }
}
