package Leetcode3737;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1};
        int target = 1;
        System.out.println(new Solution().countMajoritySubarrays(nums, target));
    }
    public int countMajoritySubarrays(int[] nums, int target){
       int n = nums.length;
       int ans = 0;
       for(int i = 0; i < n; i++){
           int sum = 0;
           for(int j = i; j < n; j++){
               if(nums[j] == target){
                   sum += 1;
               } else {
                   sum -= 1;
               }
               if(sum > 0){
                   ans++;
               }
           }
       }
       return ans;
    }
}
