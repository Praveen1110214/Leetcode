package Leetcode2413;

public class Solution {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(new Solution().smallestEvenMultiple(n));
    }
    public int smallestEvenMultiple(int n) {
        int i = 1;
        while(true) {
            if(i % 2 == 0 && i % n == 0){
                return i;
            }
            i++;
        }
    }
}
