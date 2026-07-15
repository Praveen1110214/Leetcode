package Leetcode1301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> board = new ArrayList<>();
        board.add("E23");
        board.add("2X2");
        board.add("12S");
        System.out.println(Arrays.toString(new Solution().pathsWithMaxScore(board)));
    }
    int MOD = 1_000_000_007;
    public int[] pathsWithMaxScore(List<String> board){
        int n = board.size();
        int[][] scores = new int[n][n];
        int[][] ways = new int[n][n];
        ways[n - 1][n - 1] = 1;
        for(int row = n - 1; row >= 0; row--) {
            for(int col = n - 1; col >= 0; col--) {
                char cell = board.get(row).charAt(col);
                if(cell == 'S' || cell == 'X') continue;
                update(row, col, row + 1, col, scores, ways, n);
                update(row, col, row, col + 1, scores, ways, n);
                update(row, col, row + 1, col + 1, scores, ways, n);
                if(ways[row][col] > 0 && cell != 'E'){
                    scores[row][col] += cell - '0';
                }
            }
        }
        return new int[]{scores[0][0], ways[0][0]};
    }
    private void update(int row, int col, int prevRow, int prevCol, int[][] scores, int[][] ways, int n){
        if(prevRow >= n || prevCol >= n) return;
        if(ways[prevRow][prevCol] == 0) return;;
        if(scores[prevRow][prevCol] > scores[row][col]){
            scores[row][col] = scores[prevRow][prevCol];
            ways[row][col] = ways[prevRow][prevCol];
        } else if(scores[prevRow][prevCol] == scores[row][col]){
            ways[row][col] = (ways[row][col] + ways[prevRow][prevCol]) % MOD;
        }

    }
}
