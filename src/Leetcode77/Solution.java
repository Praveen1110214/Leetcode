package Leetcode77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k));
    }
    static List<List<Integer>> combine(int n, int k){
        backtrack(1, n, k, new ArrayList<>());
        return ans;
    }
    static void backtrack(int start, int n, int k, List<Integer> curr){
        if(curr.size() == k){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i <= n; i++){
            curr.add(i);
            backtrack(i + 1, n, k, curr);
            curr.remove(curr.size() - 1);
        }
    }
}
