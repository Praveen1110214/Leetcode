package Leetcode1137;

public class NthTribonacciNumber {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }
    static int tribonacci(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;
        int first = 0;
        int second = 1;
        int third = 1;
        int current = 0;
        for(int i = 3; i <= n; i++){
            current = first + second + third;
            first = second;
            second = third;
            third = current;
        }
        return current;
    }
}
