package Leetcode3718;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {42,13,99,13,71,32,64,32,63,44,6,22,8,2,55,88,43,40,71,80,95,32,46,19};
        int k = 44;
        System.out.println(new Solution().missingMultiple(nums, k));
    }
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int number = 0;
        for(int i = 1;;i++){
            if(!set.contains(i * k)){
                number = i * k;
                break;
            }
        }
        return number;
    }
}
