package Leetcode1967;

public class Solution {
    public static void main(String[] args) {
        String[] patterns = {"a","abc","bc","d"};
        String word = "abc";
        System.out.println(new Solution().numOfStrings(patterns, word));
    }
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for(String pattern : patterns){
            if(word.contains(pattern)){
                count++;
            }
        }
        return count;
    }
}
