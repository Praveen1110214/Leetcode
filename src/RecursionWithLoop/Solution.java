package RecursionWithLoop;

public class Solution {
    public static void main(String[] args) {
        int start = 1;
        new Solution().f(start);
    }
    public void f(int start) {
        System.out.println("ENTER start is: " + start);
        int i;
        for(i = start; i < 4; i++){
            f(i + 1);
        }
        System.out.println("EXIT start is: " + start);
    }
}
