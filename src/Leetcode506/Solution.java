package Leetcode506;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < score.length; i++){
            priorityQueue.offer(new int[]{score[i], i});
        }
        String[] result = new String[score.length];
        int rank = 1;
        while (!priorityQueue.isEmpty()){
            int[] currentScore = priorityQueue.poll();
            int index = currentScore[1];
            if(rank == 1) result[index] = "Gold Medal";
            else if(rank == 2) result[index] = "Silver Medal";
            else if(rank == 3) result[index] = "Bronze Medal";
            else result[index] = String.valueOf(rank);
            rank++;
        }
        return result;
    }
}
