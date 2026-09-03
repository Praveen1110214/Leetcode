package Leetcode316;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new Solution().removeDuplicateLetters(s));
    }
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        boolean[] visited = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(visited[ch - 'a']) {
                continue;
            }
            while(
                    !stack.isEmpty()
                    && stack.peek() > ch
                    && lastIndex[stack.peek() - 'a'] > i
            ) {
                char removed = stack.pop();
                visited[removed - 'a'] = false;
            }
            stack.push(ch);
            visited[ch - 'a'] = true;
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
