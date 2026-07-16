package Leetcode1995;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6};
        System.out.println(new Solution().countQuadruplets(nums));
    }
    public int countQuadruplets(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++) {
                for(int k = j + 1; k < n - 1; k++) {
                    for(int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] == nums[l]) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    public int countQuadruplets1(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int c = n - 2; c >= 2; c--) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int d = c + 1; d < n; d++) {
                int diff = nums[d] - nums[c];
                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }
            for (int a = 0; a < c; a++) {
                for (int b = a + 1; b < c; b++) {
                    ans += map.getOrDefault(nums[a] + nums[b], 0);
                }
            }
        }
        return ans;
    }
}
