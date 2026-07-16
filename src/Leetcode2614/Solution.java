package Leetcode2614;

public class Solution {
    public static void main(String[] args) {
        int[][] nums = {{1,2,3}, {5,6,7}, {7,8,9}};
        System.out.println(new Solution().diagonalPrime(nums));
    }
    public int diagonalPrime(int[][] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int main = nums[i][i];
            int secondary = nums[i][nums.length - i - 1];
            if(isPrime(main) && main > res) {
                res = main;
            }
            if(isPrime(secondary) && secondary > res) {
                res = secondary;
            }
        }
        return res;
    }
    private boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= n / i; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
