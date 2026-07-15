package Leetcode1030;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int dist = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                list.add(new int[]{i, j, dist});
            }
        }
        list.sort((a, b) -> a[2] - b[2]);
        int[][] ans = new int[rows * cols][2];
        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }
        return ans;
    }
}
