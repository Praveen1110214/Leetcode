package Leetcode394;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[b2[s]]";
        System.out.println(decodeString(s));
    }
    static String decodeString(String s){
        int num = 0;
        StringBuilder current = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            } else if(ch == '['){
                countStack.push(num);
                stringStack.push(current);
                num = 0;
                current = new StringBuilder();
            } else if(ch == ']'){
                int repeat = countStack.pop();
                StringBuilder previous = stringStack.pop();
                for(int i = 0; i < repeat; i++){
                    previous.append(current);
                }
                current = previous;
            } else {
                current.append(ch);
            }
        }
        return current.toString();
    }
}
