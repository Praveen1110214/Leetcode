package Leetcode2427;

public class Solution {
    public static void main(String[] args) {
        int a = 25;
        int b = 30;
        System.out.println(new Solution().commonFactors(a,b));
    }
    public int commonFactors(int a, int b) {
        int count = 0;
        for(int i = 1; i <= Math.min(a,b); i++){
            if(a % i == 0 && b % i == 0) count++;
        }
        return count;
    }
}
