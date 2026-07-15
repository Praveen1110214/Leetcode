package Leetcode661;

public class Solution {
    public static void main(String[] args) {

    }
    public int[][] imageSmoother(int[][] img){
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int sum = img[i][j];
                int count = 1;
                for(int k = 0; k < 8; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                        sum += img[nr][nc];
                        count++;
                    }
                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
