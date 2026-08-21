package Leetcode168;

public class Solution {
    public static void main(String[] args) {
        int columnNumber = 5;
        System.out.println(new Solution().convertToTitle(5));
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber != 0) {
            columnNumber --;
            char currentChar = (char) ('A' + columnNumber % 26);
            sb.append(currentChar);
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
