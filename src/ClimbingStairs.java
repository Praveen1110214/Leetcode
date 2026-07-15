public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(climbStairs(n));
    }
    static int climbStairs(int n) {
        int previousTwo = 0;
        int previousOne = 1;
        for(int i = 0; i < n; i++){
            int current = previousOne + previousTwo;
            previousTwo = previousOne;
            previousOne = current;
        }
        return previousOne;
    }
}
