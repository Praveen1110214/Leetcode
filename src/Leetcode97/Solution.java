package Leetcode97;
public class Solution {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "cd";
        String s3 = "cabd";
        System.out.println(new Solution().isInterleave(s1, s2, s3));
    }
    Boolean[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return dfs(0, 0, s1, s2, s3);
    }
    private boolean dfs(int i, int j, String s1, String s2, String s3){
        if(i + j == s3.length()) return true;
        if(memo[i][j] != null) return memo[i][j];
        boolean ans = false;
        if( i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) ans |= dfs(i + 1, j, s1, s2, s3);
        if( j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) ans |= dfs(i, j + 1, s1, s2, s3);
        return memo[i][j] = ans;
    }
}