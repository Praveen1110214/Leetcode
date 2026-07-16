import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        System.out.println(uniquePaths2(m, n));
    }
    static int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row > 0){
                    dp[row][col] += dp[row - 1][col];
                }
                if(col > 0){
                    dp[row][col] += dp[row][col - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    static  int uniquePaths2(int m, int n){
        int[] aboveRow = new int[n];
        Arrays.fill(aboveRow, 1);
        for(int row = 1; row < m; row++){
            int[] currentRow = new int[n];
            Arrays.fill(currentRow, 1);
            for(int col = 1; col < n; col++){
                currentRow[col] = currentRow[col - 1] + aboveRow[col];
            }
            aboveRow = currentRow;
        }
        return aboveRow[n - 1];
    }
}
