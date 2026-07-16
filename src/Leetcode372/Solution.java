package Leetcode372;

public class Solution {
    public static void main(String[] args) {
        int a = 1;
        int[] b = {4,3,3,8,5,2};
        System.out.println(new Solution().superPow(a,b));
    }
    private static final int MOD = 1337;
    public int superPow(int a, int[] b) {
        int result = 1;
        for(int digit : b) {
            result = (pow(result, 10) * pow(a, digit)) % MOD;
        }
        return result;
    }
    private int pow(int base, int exponent) {
        int result = 1;
        base %= MOD;
        for(int i = 0; i < exponent; i++) {
            result = (result * base) % MOD;
        }
        return  result;
    }
}
