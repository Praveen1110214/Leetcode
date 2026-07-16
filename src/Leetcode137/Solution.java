package Leetcode137;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2};
        System.out.println(new Solution().singleNUmber(nums));
    }
    public int singleNUmber(int[] nums){
        int ans = 0;
        for(int bit = 0; bit < 32; bit++){
            int count = 0;
            for(int num : nums){
                if(((num >> bit) & 1) == 1){
                    count++;
                }
            }
            if(count % 3 != 0){
                ans |= (1 << bit);
            }
        }
        return ans;
    }
}
