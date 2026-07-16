package Leetcode2500;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public int deleteGreatestValue(int[][] grid){
        for(int[] row : grid){
            Arrays.sort(row);
        }
        int result = 0;
        for(int col = 0; col < grid[0].length; col++){
            int max = 0;
            for(int row = 0; row < grid.length; row++){
                max = Math.max(max, grid[row][col]);
            }
            result += max;
        }
        return result;
    }
}
