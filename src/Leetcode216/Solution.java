package Leetcode216;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int k = 3;
        int n = 7;
        System.out.println(new Solution().combinationSum3(k, n));
    }
    public List<List<Integer>> combinationSum3(int k, int n){
        backTrack(1, k, n, new ArrayList<>());
        return result;
    }
    private void backTrack(int start, int k, int target, List<Integer> curr){
        if(target == 0 && curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || curr.size() > k){
            return;
        }
        for(int i = start; i <= 9; i++){
            curr.add(i);
            backTrack(i + 1, k, target - i, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
