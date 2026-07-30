package Leetcode3016;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        String word = "xyzxyzxyzxyz";
        System.out.println(new Solution().minimumPushes(word));
    }
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i = 0; i < word.length(); i++){
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int position = 0;
        int ans = 0;
        for(int i = 25; i >= 0; i--) {
            if(freq[i] == 0) break;
            ans += freq[i] * ((position / 8) + 1);
            position++;
        }
        return ans;
    }
}
