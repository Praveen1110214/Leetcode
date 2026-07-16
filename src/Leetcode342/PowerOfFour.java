package Leetcode342;

public class PowerOfFour {
    public static void main(String[] args) {
        int n = 65;
        System.out.println(isPowerOfFour(n));
    }
    static boolean isPowerOfFour(int n){
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n % 4 != 0) return false;
        else return isPowerOfFour(n / 4);
    }
}
