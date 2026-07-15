package Leetcode3264;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,1,3,5,6};
        int k = 2;
        int multiplier = 2;
        System.out.println(Arrays.toString(new Solution().getFinalState1(nums, k, multiplier)));
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        for(int i = 0; i < nums.length; i++){
            priorityQueue.offer(new int[]{nums[i], i});
        }
        int n = nums.length;
        int[] result = new int[n];
        while(k > 0){
            int[] current = priorityQueue.poll();
            int value = current[0];
            int index = current[1];
            priorityQueue.offer(new int[]{value * multiplier, index});
            k--;
        }
        while (!priorityQueue.isEmpty()){
            int[] current = priorityQueue.poll();
            int index = current[1];
            int value = current[0];
            result[index] = value;
        }
        return result;
    }
    public int[] getFinalState1(int[] nums, int k, int multiplier) {
        for(int i = 0; i < k; i++){
            int min = Integer.MAX_VALUE;
            for(int num : nums){
                min = Math.min(num, min);
            }
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == min){
                    nums[j] = min * multiplier;
                    break;
                }
            }
        }
        return nums;
    }
}
