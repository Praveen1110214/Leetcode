package Leetcode3756;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "10203004";
        int[][] queries = {{0, 7}, {1, 3}, {4, 6}};
        System.out.println(Arrays.toString(new Solution().sumAndMultiply(s, queries)));
    }
    public int[] sumAndMultiply(String s, int[][] queries) {
        int MOD = 1_000_000_007;
        int[] answer = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            String queriedString = s.substring(l,r+1);
            long sum = 0;
            long place = 1;
            long result = 0;
            long n = Long.parseLong(queriedString);
            while(n != 0) {
                long digit = n % 10;
                if(digit != 0) {
                    sum += digit;
                    result = ((digit * place) + result) % MOD;
                    place *= 10;
                }
                n /= 10;
            }
            answer[i] = (int)((sum * result) % MOD);
            i++;
        }
        return answer;
    }
}
