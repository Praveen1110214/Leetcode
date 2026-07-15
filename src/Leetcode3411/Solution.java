package Leetcode3411;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,1,1};
        System.out.println(new Solution().maxLength(nums));
    }
    public int maxLength(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int product = 1;
            int gcd = 0;
            int lcm = 1;
            for(int j = i; j < nums.length; j++){
                product *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j]);
                if(product == lcm * gcd) {
                    res = Math.max(res, j - i + 1);
                }
            }
        }
        return res;
    }
    private int gcd(int a, int b){
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
    private int lcm(int a, int b){
        return (a / gcd(a,b)) * b;
    }
}
