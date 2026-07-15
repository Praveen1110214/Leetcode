package Leetcode1358;

public class Solution {
    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new Solution().numberOfSubstrings(s));
    }
    public int numberOfSubstrings(String s) {
        int len = s.length();
        if(len < 3) return 0;
        int result = 0;
        int left = 0;
        int[] count = new int[3];
        for(int right = 0; right < len; right++){
            count[s.charAt(right) - 'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                result += len - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;
    }
}
