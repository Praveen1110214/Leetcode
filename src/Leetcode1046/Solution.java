package Leetcode1046;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones){
            priorityQueue.offer(stone);
        }
        while ((priorityQueue.size() > 1)) {
            int firstStone = priorityQueue.poll();
            int secondStone = priorityQueue.poll();
            if(firstStone != secondStone) priorityQueue.offer(firstStone - secondStone);
        }
        return priorityQueue.isEmpty() ? 0 : priorityQueue.peek();
    }
}
