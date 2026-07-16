package Leetcode766;

public class solution {
    public static void main(String[] args) {

    }
    public boolean isToeplitzMatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 || n == 1) return true;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i - 1][j - 1] != matrix[i][j]) return false;
            }
        }
        return true;
    }
}
