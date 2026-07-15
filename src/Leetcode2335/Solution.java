package Leetcode2335;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for(int num : amount){
            if(num > 0) {
                priorityQueue.offer(num);
            }
        }
        int seconds = 0;
        while(priorityQueue.size() > 1){
            int first = priorityQueue.poll();
            int second = priorityQueue.poll();
            first--;
            second--;
            seconds++;
            if(first > 0) priorityQueue.offer(first);
            if(second > 0) priorityQueue.offer(second);
        }
        if(!priorityQueue.isEmpty()){
            seconds += priorityQueue.poll();
        }
        return seconds;
    }
}
