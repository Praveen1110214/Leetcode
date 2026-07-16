package Leetcode1979;

public class Solution {
    public static void main(String[] args) {

    }
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        int gcd = 1;
        for(int i = 1; i <= min; i++){
            if(min % i == 0 && max % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
