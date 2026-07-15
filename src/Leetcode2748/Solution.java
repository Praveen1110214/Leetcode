package Leetcode2748;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,5,1,4};
        System.out.println(new Solution().countBeautifulPairs(nums));
    }
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int firstDigit = nums[i];
            while(firstDigit >= 10)
                firstDigit /= 10;
            for(int j = i + 1; j < nums.length; j++) {
                int secondDigit = nums[j] % 10;
                if(gcd(firstDigit, secondDigit) == 1){
                    count++;
                }
            }
        }
        return count;
    }
    private int gcd(int a, int b) {
        for(int i = Math.max(a, b); i >= 1; i--) {
            if(a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
