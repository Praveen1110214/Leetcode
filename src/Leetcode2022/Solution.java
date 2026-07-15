package Leetcode2022;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] original = {1,2,3,4};
        int m = 2;
        int n = 2;
        System.out.println(Arrays.deepToString(new Solution().construct2DArray(original, m, n)));
    }
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m * n) return new int[0][0];
        int[][] result = new int[m][n];
        int row = 0;
        int col = 0;
        for (int j : original) {
            if (col > n - 1) {
                col = 0;
                row++;
            }
            result[row][col] = j;
            col++;
        }
        return result;
    }
}
