package Leetcode3699;

public class Solution {
    public static void main(String[] args) {
        int n = 3;
        int l = 4;
        int r = 5;
        System.out.println(new Solution().zigZagArrays(n, l, r));
    }
    public static final int MOD = 1_000_000_007;
    public int zigZagArrays(int n, int l, int r){
        int m = r - l + 1;
        if(n == 1){
            return m;
        }
        long[] up = new long[m];
        long[] down = new long[m];
        for(int i = 0; i < m; i++){
            up[i] = i;
            down[i] = m - 1 - i;
        }
        if(n == 2){
            long ans = 0;
            for(long x : up){
                ans = (ans + x) % MOD;
            }
            return (int) ans;
        }
        for(int len = 3; len <= n; len++){
            long[] prefix = new long[m + 1];
            long[] suffix = new long[m + 1];
            for(int i = 0; i < m; i++){
                prefix[i + 1] = (prefix[i] + down[i]) % MOD;
            }
            for(int i = m - 1; i >= 0; i--){
                suffix[i] = (suffix[i + 1] + up[i]) % MOD;
            }

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for(int j = 0; j < m; j++){
                newUp[j] = prefix[j];
                newDown[j] = suffix[j + 1];
            }
            up = newUp;
            down = newDown;
        }
        long ans = 0;
        for(long x : up){
            ans = (ans + x) % MOD;
        }
        for(long x : down){
            ans = (ans + x) % MOD;
        }
        return (int)ans;
    }
}
