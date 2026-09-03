package Leetcode292;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().canWinNim(n));
    }
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
