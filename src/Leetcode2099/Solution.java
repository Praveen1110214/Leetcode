package Leetcode2099;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[k];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i = 0; i < n; i++){
            priorityQueue.offer(new int[]{nums[i], i});
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        List<int[]> selected = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            selected.add(priorityQueue.poll());
        }
        selected.sort((a, b) -> a[1] - b[1]);
        for(int i = 0; i < k; i++){
            result[i] = selected.get(i)[0];
        }
        return result;
    }
}
