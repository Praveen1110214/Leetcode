package Leetcode1260;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int total = m * n;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int index = i * n + j;
                int newIndex = (index + k) % total;
                int newRow = newIndex / n;
                int newCol = newIndex % n;
                res[newRow][newCol] = grid[i][j];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < m; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < n; j++){
                row.add(res[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}
