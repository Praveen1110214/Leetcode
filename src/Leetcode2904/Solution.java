package Leetcode2904;

public class Solution {
    public static void main(String[] args) {
        String s = "100011001";
        int k = 3;
        System.out.println(new Solution().shortestBeautifulSubstring(s, k));
    }
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        String result = "";
        for(int right = 0; right < s.length(); right++){
            if(s.charAt(right) == '1') {
                ones++;
            }
            while(ones == k){
                String candidate = s.substring(left, right + 1);
                if (result.isEmpty()
                        || candidate.length() < result.length()
                        || (candidate.length() == result.length()
                        && candidate.compareTo(result) < 0)) {
                    result = candidate;
                }
                if(s.charAt(left) == '1'){
                    ones--;
                }
                left++;
            }
        }
        return result;
    }
}