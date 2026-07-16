import java.util.Arrays;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }
    static int[][] generateMatrix(int n){
        int[][] result = new int[n][n];
        int[] dirs = {0, 1, 0, -1, 0};
        int currentRow = 0;
        int currentCol = 0;
        int directionIndex = 0;
        for(int value = 1; value <= n * n; value++){
            result[currentRow][currentCol] = value;
            int nextRow = currentRow + dirs[directionIndex];
            int nextCol = currentCol + dirs[directionIndex + 1];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || result[nextRow][nextCol] != 0){
                directionIndex = (directionIndex + 1) % 4;
            }
            currentRow += dirs[directionIndex];
            currentCol += dirs[directionIndex + 1];
        }
        return result;
    }
}
