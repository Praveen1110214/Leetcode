package Leetcode3090;

public class Solution {
    public static void main(String[] args) {
        String s = "bcbbbcba";
        System.out.println(new Solution().maximumLengthSubstring(s));
    }
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int max = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
            int currChar = s.charAt(right) - 'a';
            freq[currChar]++;
            while(freq[currChar] > 2){
                int leftChar = s.charAt(left) - 'a';
                freq[leftChar]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
