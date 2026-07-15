package Leetcode892;

public class Solution {
    public static void main(String[] args) {

    }
    public int surfaceArea(int[][] grid){
        int n = grid.length;
        int area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int h = grid[i][j];
                if(h == 0) continue;
                area += h * 6;
                area -= (h - 1) * 2;
                if(i > 0) {
                    area -= 2 * Math.min(h, grid[i - 1][j]);
                }
                if(j > 0){
                    area -= 2 * Math.min(h, grid[i][j - 1]);
                }
            }
        }
        return area;
    }
}
