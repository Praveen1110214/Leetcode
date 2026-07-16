import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeros(matrix);
    }
    static void setZeros(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        int i = 0, j = 0;
        while(i < m ){
            while(j < n){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
                j++;
            }
            j = 0;
            i++;
        }
        i = 0; j = 0;
        while(i < m){
            if(row[i]){
                while(j < n){
                    matrix[i][j] = 0;
                    j++;
                }
                j = 0;
            }
            i++;
        }
        i = 0; j = 0;
       while(j < n){
           if(col[j]){
               while(i < m){
                   matrix[i][j] = 0;
                   i++;
               }
               i = 0;
           }
           j++;
       }
        System.out.println(Arrays.deepToString(matrix));
    }
}
