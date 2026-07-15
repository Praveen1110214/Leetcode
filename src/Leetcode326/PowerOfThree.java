package Leetcode326;

public class PowerOfThree {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(isPowerOfThree(n));
    }
    static boolean isPowerOfThree(int n){
        if(n <= 0) return false;
        if(n == 1) return true;
        if(n % 3 != 0) return false;
        else return isPowerOfThree(n / 3);
    }
}
