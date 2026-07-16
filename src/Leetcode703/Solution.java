package Leetcode703;

import java.util.PriorityQueue;

class KthLargest {
    int k;
    PriorityQueue<Integer> priorityQueue;
    public KthLargest(int k, int[] nums){
        this.k = k;
        this.priorityQueue = new PriorityQueue<>();
        for(int num : nums){
            priorityQueue.offer(num);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
    }
    public int add(int val){
        priorityQueue.offer(val);
        if(priorityQueue.size() > k){
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

}
public class Solution{
    public static void main(String[] args) {

    }
}
