package Leetcode1464;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);
        for(int num : nums){
            priorityQueue.offer(num);
        }
        int product = 0;
        if(!priorityQueue.isEmpty() && priorityQueue.size() >= 2) {
            int first = priorityQueue.poll() - 1;
            int second = priorityQueue.poll() - 1;
            product = first * second;
        }
        return product;
    }
    public int maxProduct1(int[] nums){
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int current = nums[i];
            if(current > firstLargest){
                secondLargest = firstLargest;
                firstLargest = current;
            } else if(current > secondLargest){
                secondLargest = current;
            }
        }
        return (firstLargest - 1) * (secondLargest - 1);
    }
}
