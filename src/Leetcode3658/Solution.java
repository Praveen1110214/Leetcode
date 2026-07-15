package Leetcode3658;

public class Solution {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().gcdOfOddEvenSums(n));
    }
    public int gcdOfOddEvenSums(int n) {
        int odd = n * n;
        int even = n * (n + 1);
        return gcd(odd, even);
    }
    private int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
