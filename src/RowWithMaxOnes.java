import java.util.Arrays;

public class RowWithMaxOnes {
    public static void main(String[] args) {
        int[][] mat = {{0, 1},{1, 0}};
        System.out.println(Arrays.toString(rowAndMaximumOnes(mat)));
    }
    static int[] rowAndMaximumOnes(int[][] mat){
        int index = 0;
        int maxOneCount = 0;
        for(int i = 0; i < mat.length; i++){
            int currentOneCount = 0;
            for(int j = 0; j < mat[0].length; j++){
//                if(mat[i][j] == 1) currentOneCount++;
                currentOneCount += mat[i][j];
            }
            if(currentOneCount > maxOneCount) {
                index = i;
                maxOneCount = currentOneCount;
            }
        }
        return new int[]{index, maxOneCount};
    }
}
