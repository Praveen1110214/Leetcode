package Leetcode682;

import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        String[] operations = {"5","2","C","D","+"};
        System.out.println(new Solution().calPoints(operations));
    }
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String operation : operations) {
            if(operation.equals("C") ) {
                stack.pop();
            }else if(operation.equals("D")) {
                int num = stack.peek();
                num *= 2;
                stack.push(num);
            } else if(operation.equals("+")){
                int sum = stack.getLast() + stack.get(stack.size() - 2);
                stack.push(sum);
            } else stack.push(Integer.parseInt(operation));

        }
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
