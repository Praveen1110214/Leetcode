package Leetcode89;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().grayCodeBackTracking(n));
    }
    public List<Integer> grayCode(int n){
        int size = 1 << n;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < size; i++){
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }
    public List<Integer> grayCodeBackTracking(int n){
        if(n == 0) return List.of(0);
        List<Integer> prev = grayCodeBackTracking(n - 1);
        List<Integer> ans = new ArrayList<>(prev);
        int addBit = 1 << (n - 1);
        for (int i = prev.size() - 1; i >= 0; i--){
            ans.add(prev.get(i) + addBit);
        }
        return ans;
    }
}
