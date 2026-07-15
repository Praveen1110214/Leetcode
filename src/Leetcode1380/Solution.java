package Leetcode1380;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            int min = Integer.MAX_VALUE;
            int columnToCheck = 0;
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] < min) {
                    min = matrix[i][j];
                    columnToCheck = j;
                }
            }
            boolean isLucky = true;
            for(int k = 0; k < matrix.length; k++){
                if(matrix[k][columnToCheck] > min){
                    isLucky = false;
                    break;
                }
            }
            if(isLucky) result.add(min);
        }
        return result;
    }
}