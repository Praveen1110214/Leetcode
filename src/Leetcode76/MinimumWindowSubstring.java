package Leetcode76;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "JAKOUBJKOCABOC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
    static String minWindow(String s, String t){
        if(s.length() < t.length()) return "";
        int required = t.length();
        int[] need = new int[128];
        int minLength = Integer.MAX_VALUE;
        for(char ch : t.toCharArray()){
            need[ch]++;
        }
        int left = 0;
        int start = 0;
        int[] window = new int[128];
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            window[ch]++;
            if(need[ch] > 0 && window[ch] <= need[ch]){
                required--;
            }
            while(required == 0){
               if(right - left + 1 < minLength){
                   minLength = right - left + 1;
                   start = left;
               }
               char leftChar = s.charAt(left);
               window[leftChar]--;
               if(need[leftChar] > 0 && window[leftChar] < need[leftChar]){
                   required++;
               }
               left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
