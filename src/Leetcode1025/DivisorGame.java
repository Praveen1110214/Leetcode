package Leetcode1025;

public class DivisorGame {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(divisorGame(n));
    }
    static boolean divisorGame(int n){
        return (n % 2 == 0);
    }
}
