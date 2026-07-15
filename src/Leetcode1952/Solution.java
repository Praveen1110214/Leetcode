package Leetcode1952;

public class Solution {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().isThree(n));
    }
    public boolean isThree(int n){
        int count = 0;
        for(int i = 2; i <= n / 2; i++){
            if(n % i == 0) {
                count++;
            }
        }
        return count == 1;
    }
}
