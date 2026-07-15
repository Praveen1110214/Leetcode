package Leetcode2974;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution().numberGame(nums)));
    }
    public int[] numberGame(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);
        for(int num : nums) {
            priorityQueue.offer(num);
        }
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[n];
        while(!priorityQueue.isEmpty()){
            int alice = priorityQueue.poll();
            int bob = priorityQueue.poll();
            list.add(bob);
            list.add(alice);
        }
        for(int i = 0; i < n; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
