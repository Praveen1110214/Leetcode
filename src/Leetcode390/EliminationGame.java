package Leetcode390;

public class EliminationGame {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(lastRemaining2(n));
    }
    static int lastRemaining(int n){
        if(n == 1) return 1;
        return 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
    static int lastRemaining2(int n){
        int head = 1;
        int step = 1;
        int remaining = n;
        boolean left = true;
        while(remaining > 1){
            if(left || (remaining % 2 == 1)){
                head = head + step;
            }
            step *= 2;
            remaining /= 2;
            left = !left;
        }
        return head;
    }
}
