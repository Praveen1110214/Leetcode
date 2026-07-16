package Leetcode832;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] image = {{1,1,0}, {1,0,1}, {0,0,0}};
        System.out.println(Arrays.deepToString(new Solution().flipAndInvertImage(image)));
    }
//    public int[][] flipAndInvertImage(int[][] image){
//        int m = image.length;
//        int n = image[0].length;
//        int mid = n / 2;
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < mid; j++){
//                int temp = image[i][j];
//                image[i][j] = image[i][n - j - 1];
//                image[i][n - j - 1] = temp;
//            }
//        }
//        for(int i = 0; i < m; i++){
//            for(int j = 0; j < n; j++){
//                if(image[i][j] == 1){
//                    image[i][j] = 0;
//                } else {
//                    image[i][j] = 1;
//                }
//            }
//        }
//        return image;
//    }
    public int[][] flipAndInvertImage(int[][] image){
        for(int[] i : image){
            int u = 0;
            int v = i.length - 1;
            while(u <= v){
                int temp = i[v] ^ 1;
                i[v] = i[u] ^ 1;
                i[u] = temp;
                u++;
                v--;
            }
        }
        return image;
    }
}
