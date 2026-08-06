package Leetcode3345;

public class Solution {
    public static void main(String[] args) {
        int n = 11;
        int t = 3;
        System.out.println(new Solution().smallestNumber(n, t));
    }
    public int smallestNumber(int n, int t) {
        while(true) {
            int product = 1;
            int temp = n;
            while(temp != 0) {
                int digit = temp % 10;
                product *= digit;
                temp /= 10;
            }
            if(product % t == 0) return n;
            n++;
        }
    }
}
