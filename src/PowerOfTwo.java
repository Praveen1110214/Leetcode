public class PowerOfTwo {
    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPowerOfTwo(n));
    }
    static boolean isPowerOfTwo(int n){
        if(n == 1) return true;
        return (n & (n - 1)) == 0;
    }
}
