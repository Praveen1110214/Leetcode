package Leetcode3658;

public class Solution {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(new Solution().gcdOfOddEvenSums(n));
    }
    public int gcdOfOddEvenSums(int n) {
        int oddSum = n * n;
        int evenSum = n * (n + 1);
        return gcd(oddSum, evenSum);
    }
    private int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}
