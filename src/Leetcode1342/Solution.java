package Leetcode1342;

public class Solution {
    public static void main(String[] args) {
        int num = 14;
        System.out.println(new Solution().numberOfSteps(num));
    }
    public int numberOfSteps(int num) {
        int count = 0;
        while(num != 0) {

            if(num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            count += 1;
        }
        return count;
    }
    public int numberOfStepsRecursion(int num) {
        return helper(num, 0);
    }

    private int helper(int num, int steps) {
        if(num == 0) return steps;
        if(num % 2 == 0) return helper(num / 2, steps + 1);
        return helper(num - 1, steps + 1);
    }
}
