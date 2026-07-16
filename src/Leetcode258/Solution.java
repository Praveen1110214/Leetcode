package Leetcode258;

public class Solution {
    public static void main(String[] args) {
        int num = 38;
        System.out.println(new Solution().addDigits(num));
    }
    public int addDigits(int num) {
       while(num >= 10){
           int sum = 0;
           while(num > 0){
               int digit = num % 10;
               sum += digit;
               num /= 10;
           }
           num = sum;
       }
       return num;
    }

}
