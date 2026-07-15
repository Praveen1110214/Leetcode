package Leetcode78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(sol.subSets(nums));
    }
    public List<List<Integer>> subSets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
    public void backTrack(int[] nums, int index, List<Integer> curr, List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        backTrack(nums, index + 1, curr, result);
        curr.add(nums[index]);
        backTrack(nums, index + 1, curr, result);
        curr.remove(curr.size() - 1);
    }
}
