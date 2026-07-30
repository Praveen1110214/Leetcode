package Leetcode3014;

public class Solution {
    public static void main(String[] args) {
        String word = "xycdefghij";
        System.out.println(new Solution().minimumPushes(word));
    }
    public int minimumPushes(String word) {
        int ans = 0;
        int i = 1;
        int add = 1;
        while(i <= word.length()){
            ans += add;
            if(i % 8 == 0){
                add++;
            }
            i++;
        }
        return ans;
    }
    public int minimumPushes2(String word){
        int ans = 0;
        for(int i = 0; i < word.length(); i++){
            ans += (i / 8) + 1;
        }
        return ans;
    }
}
