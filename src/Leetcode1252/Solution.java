package Leetcode1252;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(new Solution().oddCells(m, n, indices));
    }
    public int oddCells(int m, int n, int[][] indices) {
        int[][] result = new int[m][n];
        for(int[] index : indices) {
            int row = index[0];
            int col = index[1];
            for(int resCol = 0; resCol < n; resCol++) {
                result[row][resCol]++;
            }
            for(int resRow = 0; resRow < m; resRow++){
                result[resRow][col]++;
            }
        }
        System.out.println(Arrays.deepToString(result));
        int oddCount = 0;
        for(int row = 0; row < result.length; row++) {
            for(int col = 0; col < result[0].length; col++){
                if(result[row][col] % 2 != 0) {
                    oddCount++;
                }
            }
        }
        return oddCount;
    }
}
