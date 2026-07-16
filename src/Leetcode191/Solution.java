package Leetcode191;

public class Solution {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(new Solution().hammingWeight(n));
    }
    public int hammingWeight(int n) {
        int count = 0;
        while(n > 0) {
            count += n & 1;
            n = n >>1;
        }
        return count;
    }
}
