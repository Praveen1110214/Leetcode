package Leetcode3499;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String s = "1000100";
        System.out.println(new Solution().maxActiveSectionsAfterTrade(s));
    }
    public int maxActiveSectionsAfterTrade(String s){
        int ones = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1') ones++;
        }
        String t = "1" + s + "1";
        List<Character> chars = new ArrayList<>();
        List<Integer> lens = new ArrayList<>();
        int  i = 0;
        while(i < t.length()) {
            int j = i;
            while(j < t.length() && t.charAt(i) == t.charAt(j)) {
                j++;
            }
            chars.add(t.charAt(i));
            lens.add(j - i);
            i = j;
        }
        int maxGain = 0;
        for(int k = 1; k < chars.size() - 1; k++){
            if(chars.get(k) == '1') {
                maxGain = Math.max(maxGain, lens.get(k - 1) + lens.get(k + 1));
            }
        }
        return ones + maxGain;
    }
}