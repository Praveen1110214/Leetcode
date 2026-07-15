package Leetcode2558;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] gifts = {25, 64, 9, 4, 100};
        int k = 4;
        System.out.println(new Solution().pickGifts(gifts, k));
    }
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for(int gift : gifts){
            priorityQueue.offer(gift);
        }
        while(k > 0){
            int biggest = priorityQueue.poll();
            int remaining = (int)Math.sqrt(biggest);
            priorityQueue.offer(remaining);
            k--;
        }
        long result = 0;
        while(!priorityQueue.isEmpty()){
            result += priorityQueue.poll();
        }
        return result;
    }
}
