package Leetcode3517;

public class Solution {
    public static void main(String[] args) {
        String s = "daccad";
        System.out.println(new Solution().smallestPalindrome(s));
    }
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        StringBuilder left = new StringBuilder();
        char middle = 0;
        for(int i = 0; i < 26; i++){
            int pairs = freq[i] / 2;
            while(pairs-- > 0) {
                left.append((char)('a' + i));
            }
            if((freq[i] & 1) == 1) {
                middle = (char)(i + 'a');
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(left);
        if(middle != 0) {
            ans.append(middle);
        }
        ans.append(left.reverse());
        return ans.toString();
    }
}
