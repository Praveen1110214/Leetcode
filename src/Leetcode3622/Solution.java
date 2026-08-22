package Leetcode3622;

public class Solution {
    public static void main(String[] args) {
        int n = 99;
        System.out.println(new Solution().checkDivisibility(n));
    }
    int sum = 0;
    int product = 1;
    public boolean checkDivisibility(int n) {
        digitSumAndProduct(n);
        return n % (sum + product) == 0;
    }
    private void digitSumAndProduct(int num) {
        while(num != 0) {
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }

    }
}
