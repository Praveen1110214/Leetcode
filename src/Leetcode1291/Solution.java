package Leetcode1291;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int low = 100;
        int high = 300;
        System.out.println(new Solution().sequentialDigits(low, high));
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int start = 1; start <= 9; start++){
            int num = start;
            for(int next = start + 1; next <= 9; next++){
                num = num * 10 + next;
                if(num >= low && num <= high){
                    list.add(num);
                }
            }
        }
        Collections.sort(list);
        return list;
    }
    public List<Integer> sequentialDigits1(int low, int high) {
        int[] nums = {12, 23, 34, 45, 56, 67, 78, 89, 123, 234, 345, 456, 567,
                678, 789, 1234, 2345, 3456, 4567, 5678, 6789, 12345, 23456,
                34567, 45678, 56789, 123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789, 12345678, 23456789, 123456789};
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= low && nums[i] <= high) {
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
