package Leetcode347;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(new Solution().topKFrequent(nums, k)));;
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = priorityQueue.poll()[0];
        }
        return ans;
    }
}
