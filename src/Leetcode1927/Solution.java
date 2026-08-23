package Leetcode1927;

public class Solution {
    public static void main(String[] args) {
        String num = "?3295???";
        System.out.println(new Solution().sumGame(num));
    }
    public boolean sumGame(String num) {
        int leftQuestionMark = 0;
        int leftSum = 0;
        for(int i = 0; i < num.length() / 2; i++){
            if(num.charAt(i) == '?'){
                leftQuestionMark++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }

        int rightQuestionMark = 0;
        int rightSum = 0;
        for(int i = num.length() / 2; i < num.length(); i++){
            if(num.charAt(i) == '?') {
                rightQuestionMark++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }
        int totalQuestionMark = leftQuestionMark + rightQuestionMark;
        int questionMarkDifference = rightQuestionMark - leftQuestionMark;
        int sumDifference = leftSum - rightSum;
        return totalQuestionMark % 2 == 1 || sumDifference != 9 * questionMarkDifference / 2;
    }
}
