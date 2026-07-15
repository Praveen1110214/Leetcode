package Leetcode306;

public class Solution {
    public static void main(String[] args) {
        String num = "112358";
        System.out.println(new Solution().isAdditiveNumber(num));
    }
    public boolean isAdditiveNumber(String num){
        int n = num.length();
        for(int i = 1; i < n; i++){
            if(num.charAt(0) == '0') break;
            long first = Long.parseLong(num.substring(0, i));
            for(int j = i + 1; j < n; j++){
                if(num.charAt(i) == '0' && j - i > 1) break;
                long second = Long.parseLong(num.substring(i, j));
                if(dfs(first, second, j, num)) return true;
            }
        }
        return false;
    }
    private boolean dfs(long first, long second, int start, String num){
        if(start == num.length()) return true;
        long sum = first + second;
        String sumStr = String.valueOf(sum);
        if(!num.startsWith(sumStr, start)){
            return false;
        }
        return dfs(second,sum, start + sumStr.length(), num);
    }
}
