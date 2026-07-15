package Leetcode3612;

public class Solution {
    public static void main(String[] args) {
        String s = "a#b%*";
        System.out.println(processStr(s));
    }
    static String processStr(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z') sb.append(ch);
            if(ch == '*'){
                if(sb.length() > 0){
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            if(ch == '#'){
                sb.append(sb);
            }
            if(ch == '%'){
                int len = sb.length();
                StringBuilder newSb = new StringBuilder();
                for(int j = len - 1; j >= 0; j--){
                    newSb.append(sb.charAt(j));
                }
                sb = newSb;
            }

        }
        return sb.toString();
    }
}
