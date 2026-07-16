package Leetcode3304;

public class FindKthCharInStrGameI {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(kthCharacter(n));
    }
    static char kthCharacter(int k){
        return solve(k);
    }
    static char solve(long k){
        if(k == 1)return 'a';
        long length = 1;
        while(length < k) length *= 2;
        long half = length / 2;
        if(k <= half) return solve(k);
        char ch = solve(k - half);
        return (char) ('a' + ((ch - 'a' + 1) % 26));
    }
}
