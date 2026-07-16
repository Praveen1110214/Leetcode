package Leetcode139;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "Leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"Leet" ,"code"});
        System.out.println(new Solution().wordBreak(s, wordDict));
    }
    private Boolean[] memo;
    private Set<String> dict;
    public boolean wordBreak(String s, List<String> wordDict){
        memo = new Boolean[s.length()];
        dict = new HashSet<>(wordDict);
        return dfs(s, 0);
    }
    private boolean dfs(String s, int start){
        if(start == s.length()){
            return true;
        }
        if(memo[start] != null) {
            return memo[start];
        }
        for(int end = start + 1; end <= s.length(); end++){
            if(dict.contains(s.substring(start, end))){
                if(dfs(s, end)){
                    memo[start] = true;
                    return true;
                }
            }
        }
        memo[start] = false;
        return false;
    }
}
