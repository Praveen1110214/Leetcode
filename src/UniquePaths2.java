public class UniquePaths2 {
    private Integer[][] memo;
    private int[][] obstacleGrid;
    private int rows;
    private int cols;
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
        UniquePaths2 obj = new UniquePaths2();
        System.out.println(obj.uniquePathWithObstacles(obstacleGrid));
    }
    public int uniquePathWithObstacles(int[][] obstacleGrid){
        this.obstacleGrid = obstacleGrid;
        rows = obstacleGrid.length;
        cols = obstacleGrid[0].length;
        memo = new Integer[rows][cols];
        return dfs(0, 0);
    }
    private int dfs(int row, int col){
        if(row >= rows || col >= cols || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if(row == rows - 1 && col == cols - 1) {
            return 1;
        }
        if(memo[row][col] == null){
            int pathDown = dfs(row + 1, col);
            int pathRight = dfs(row, col + 1);
            memo[row][col] = pathRight + pathDown;
        }
        return memo[row][col];
    }
}
