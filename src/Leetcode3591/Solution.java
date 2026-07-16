package Leetcode3591;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,4};
        System.out.println(new Solution().checkPrimeFrequency(nums));
    }
    public boolean checkPrimeFrequency(int[] nums) {
        int[] freq = new int[101];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        for(int i = 0; i < freq.length; i++) {
            if(isPrime(freq[i])) {
                return true;
            }
        }
        return false;
    }
    private boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= n / i; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
