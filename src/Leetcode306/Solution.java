package Leetcode306;

public class Solution {
    public static void main(String[] args) {
        String s = "112358";
        System.out.println(new Solution().isAdditiveNumber(s));
    }
    public boolean isAdditiveNumber(String s){
        if(s.length() < 3) return false;
        for(int i = 2; i < s.length(); i++){
            if((int)s.charAt(i) != (int)s.charAt(i - 1) + (int)s.charAt(i-2)) return false;
        }
        return true;
    }

}
