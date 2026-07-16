package Leetcode264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

    }
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        priorityQueue.offer(1L);
        seen.add(1L);
        long current = 1;
        for(int i = 0; i < n; i++){
            current = priorityQueue.poll();
            long multiplyBy2 = current * 2;
            long multiplyBy3 = current * 3;
            long multiplyBy5 = current * 5;
            if(seen.add(multiplyBy2)){
                priorityQueue.offer(multiplyBy2);
            }
            if(seen.add(multiplyBy3)){
                priorityQueue.offer(multiplyBy3);
            }
            if(seen.add(multiplyBy5)){
                priorityQueue.offer(multiplyBy5);
            }
        }
        return (int) current;
    }
    public int nthUglyNumber1(int n){
        int i = 0, j = 0, k = 0;
        int f2 = 2, f3 = 3, f5 = 5;
        int[] res = new int[n];
        res[0] = 1;
        for(int index = 1; index < n; index++){
            int min = Math.min(Math.min(f2, f3), f5);
            res[index] = min;
            if(f2 == min) f2 = 2 * res[++i];
            if(f3 == min) f3 = 3 * res[++j];
            if(f5 == min) f5 = 5 * res[++k];
        }
        return res[n - 1];
    }
}
