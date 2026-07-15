package Leetcode131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> result = new ArrayList<>();
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new Solution().partition(s));
    }
    public List<List<String>> partition(String s){
        backTrack(0, s, new ArrayList<>());
        return result;
    }
    private void backTrack(int start, String s, List<String> curr){
        if(start == s.length()){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(!isPalindrome(s, start, end)){
                continue;
            }
            curr.add(s.substring(start, end + 1));
            backTrack(end + 1, s, curr);
            curr.removeLast();
        }
    }
    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(!(s.charAt(left) == s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
