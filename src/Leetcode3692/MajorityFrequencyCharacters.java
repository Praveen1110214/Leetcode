package Leetcode3692;

import java.util.HashMap;
import java.util.Map;

public class MajorityFrequencyCharacters {
    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(majorityFrequencyGroup(s));
    }
    static String majorityFrequencyGroup(String s){
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        Map<Integer, StringBuilder> freq = new HashMap<>();
        for(int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                freq.computeIfAbsent(count[i], k -> new StringBuilder()).append((char) ('a' + i));
            }
        }
        int mx = 0;
        int mv = 0;
        String ans = "";
        for(Map.Entry<Integer, StringBuilder> entry : freq.entrySet()){
            int v = entry.getKey();
            StringBuilder cs = entry.getValue();
            if(mx < cs.length() || (mx == cs.length()) && mv < v){
                mx = cs.length();
                mv = v;
                ans = cs.toString();
            }
        }
        return ans;
    }
}
