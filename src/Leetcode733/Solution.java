package Leetcode733;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.println(Arrays.deepToString(new Solution().floodFill(image, sr, sc, color)));
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;
        dfs(image, sr, sc, oldColor, color);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int oldColor, int newColor){
        if(r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if(image[r][c] != oldColor) return;
        image[r][c] = newColor;
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
    }
}
