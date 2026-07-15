package Leetcode463;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(new Solution().isLandPerimeter(grid));
    }
    public int isLandPerimeter(int[][] grid){
        int land = 0;
        int shared = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 1){
                    land++;
                    if(r > 0 && grid[r - 1][c] == 1) shared++;
                    if(c > 0 && grid[r][c - 1] == 1) shared++;
                }
            }
        }
        return 4*land - 2*shared;
    }
}
