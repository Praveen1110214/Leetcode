package Leetcode2231;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(new Solution().largestInteger(n));
    }
    public int largestInteger(int num){
        PriorityQueue<Integer> even = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> odd = new PriorityQueue<>((a, b) -> b - a);
        int temp = num;
        while(temp != 0){
            int digit = temp % 10;
            if(digit % 2 == 0) even.offer(digit);
            else odd.offer(digit);
            temp /= 10;
        }
        int result = 0;
        String number = String.valueOf(num);

        for (char ch : number.toCharArray()) {
            int digit = ch - '0';

            if (digit % 2 == 0) {
                result = result * 10 + even.poll();
            } else {
                result = result * 10 + odd.poll();
            }
        }
        return result;
    }
}
