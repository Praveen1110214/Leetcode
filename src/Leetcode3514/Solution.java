package Leetcode3514;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {6, 7, 8, 9};
        System.out.println(new Solution().uniqueXorTriplets(nums));
    }
    public int uniqueXorTriplets(int[] nums) {
        int max = 0;
        int n = nums.length;;
        for(int i = 0; i < n; i++){
            max = Math.max(nums[i], max);
        }
        int limit = max * 2 + 1;
        boolean[] pairs = new boolean[limit];
        boolean[] ans = new boolean[limit];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                pairs[nums[i] ^ nums[j]] = true;
            }
        }
        for(int i = 0; i < limit; i++) {
            if(!pairs[i]) continue;
            for(int j = 0; j < n; j++){
                ans[i ^ nums[j]] = true;
            }
        }
        int count = 0;
        for(int i = 0; i < ans.length; i++){
            if(ans[i]) count++;
        }
        return count;
    }
}
