package Leetcode2900;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"a","b","c","d"};
        int[] groups = {1,0,1,1};
        System.out.println(getLongestSubsequences(words, groups));
    }
    static List<String> getLongestSubsequences(String[] words, int[] groups){
        List<String> result = new ArrayList<>();
        int n = words.length;
        int lastGroup = groups[0];
        result.add(words[0]);
        for(int i = 1; i < n; i++){
            if(groups[i] != lastGroup){
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }
        return result;
    }
}
