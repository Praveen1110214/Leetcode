package Leetcode566;

public class Solution {
    public static void main(String[] args) {

    }
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if(r * c != m * n) return mat;
        int[][] res = new int[r][c];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int index = i * n + j;
                res[index / c][index % c] = mat[i][j];
            }
        }
        return res;
    }
}
