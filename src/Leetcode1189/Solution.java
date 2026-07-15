package Leetcode1189;
public class Solution {
    public static void main(String[] args) {
        String text = "balloon";
        System.out.println(new Solution().maxNumberOfBalloons(text));
    }
    public int maxNumberOfBalloons(String text){
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for(char ch : text.toCharArray()){
            switch (ch) {
                case 'b' : b++; break;
                case 'a' : a++; break;
                case 'l' : l++; break;
                case 'o' : o++; break;
                case 'n' : n++; break;
            }
        }

        l /= 2;
        o /= 2;

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}
