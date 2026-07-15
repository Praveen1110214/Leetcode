package Leetcode3754;

public class Solution {
    public static void main(String[] args) {
        int n = 1000;
        System.out.println(new Solution().sumAndMultiply(n));
    }

    public long sumAndMultiply(int n) {
        long sum = 0;
        int tempNum = n;
        int place = 0;
        int result = 0;
        while(tempNum != 0) {
            int digit = tempNum % 10;
            if(digit != 0){
                sum += digit;
                result = (int) (digit * Math.pow(10, place)) + result;
                place++;
            }
            tempNum /= 10;
        }
        return (long)sum * result;
    }
}
