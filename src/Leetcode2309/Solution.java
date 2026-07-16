package Leetcode2309;

public class Solution {
    public static void main(String[] args) {
        String s = "lEeTcOdE";
        System.out.println(new Solution().greatestLetter(s));
    }
    public String greatestLetter(String s) {
        int[] lowerFreq = new int[26];
        int[] upperFreq = new int[26];
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                lowerFreq[s.charAt(i) - 'a']++;
            } else {
                upperFreq[s.charAt(i) - 'A']++;
            }
        }
        for(int i = 25; i >= 0; i--) {
            if(lowerFreq[i] > 0 && upperFreq[i] > 0){
                return String.valueOf((char) (i + 65));
            }
        }
        return "";
    }
}
