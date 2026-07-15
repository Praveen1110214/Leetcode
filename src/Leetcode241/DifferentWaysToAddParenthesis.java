package Leetcode241;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthesis {
    public static void main(String[] args) {
        String expression = "2-1-1";
        System.out.println(diffWaysToCompute(expression));
    }
    static List<Integer> diffWaysToCompute(String expression){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(ch == '+' || ch == '-' || ch == '*'){
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);
                for(int left : leftResults){
                    for(int right : rightResults){
                        if(ch == '+') result.add(left + right);
                        if(ch == '-') result.add(left - right);
                        if(ch == '*') result.add(left * right);
                    }
                }
            }
        }
        if(result.isEmpty()) result.add(Integer.parseInt(expression));
        return result;
    }
}
