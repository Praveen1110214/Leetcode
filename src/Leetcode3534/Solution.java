package Leetcode3534;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int n = 5;
        int[] nums = {1,8,3,4,2};
        int maxDiff = 3;
        int[][] queries = {{0,3}, {2,4}};
        System.out.println(Arrays.toString(new Solution().pathExistenceQueries(n, nums, maxDiff, queries)));
    }
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
//        System.out.println(Arrays.deepToString(pairs));
        int m = 20;
        int[][] f = new int[n][m];
        int r = n - 1;
        for(int l = n - 1; l >= 0; l--){
            while(pairs[r][0] - pairs[l][0] > maxDiff){
                r--;
            }
            int i = pairs[l][1];
            int j = pairs[r][1];
            f[i][0] = j;
            for(int k = 1; k < m; k++){
                f[i][k] = f[f[i][k - 1]][k - 1];
            }
        }
        int[] ans = new int[queries.length];
        for (int t = 0; t < queries.length; t++) {
            int i = queries[t][0], j = queries[t][1];
            if (nums[i] > nums[j]) {
                int tmp = i;
                i = j;
                j = tmp;
            }
            if (i == j) {
                ans[t] = 0;
                continue;
            }
            if (nums[i] == nums[j]) {
                ans[t] = 1;
                continue;
            }
            int d = 0;
            for (int k = m - 1; k >= 0; k--) {
                if (nums[f[i][k]] < nums[j]) {
                    d |= 1 << k;
                    i = f[i][k];
                }
            }
            if (nums[f[i][0]] < nums[j]) {
                ans[t] = -1;
            } else {
                ans[t] = d + 1;
            }
        }
        return ans;
    }
}
