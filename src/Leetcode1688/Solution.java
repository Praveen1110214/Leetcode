package Leetcode1688;

public class Solution {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(new Solution().numberOfMatches(n));
    }
    public int numberOfMatches(int n){
        int numOfMatches = 0;
        while(n > 1) {
            if(n % 2 == 0) {
                numOfMatches += n / 2;
                n = n / 2;
            }
            else {
                numOfMatches += n / 2;
                n = n / 2 + 1;
            }

        }
        return numOfMatches;
    }
}
