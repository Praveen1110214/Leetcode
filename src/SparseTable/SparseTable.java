package SparseTable;

public class SparseTable {
    private final int[][] minTable;
    private final int[][] maxTable;
    private final int[] log;
    private int n;

    public SparseTable(int[] arr){
        n = arr.length;
        log = new int[n + 1];
        for(int i = 2; i <= n; i++){
            log[i] = log[i / 2] + 1;
        }
        int k = log[n] + 1;
        minTable = new int[k][n];
        maxTable = new int[k][n];
        for(int i = 0; i < n; i++){
            minTable[0][i] = arr[i];
            maxTable[0][i] = arr[i];
        }

        for(int level = 1; level < k; level++){
            int length = 1 << level;
            int half = 1 << (level - 1);

            for(int i = 0; i + length <= n; i++){
                minTable[level][i] = Math.min(minTable[level - 1][i], minTable[level - 1][i + half]);
                maxTable[level][i] = Math.max(maxTable[level - 1][i], maxTable[level - 1][i + half]);
            }
        }
    }
    public int rangeMin(int left, int right){
        int len = right - left + 1;
        int k = log[len];
        return Math.min(minTable[k][left], minTable[k][right - (1 << k) + 1]);
    }
    public int rangeMax(int left, int right){
        int len = right - left + 1;
        int k = log[len];
        return Math.max(maxTable[k][left], maxTable[k][right - (1 << k) + 1]);
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 7, 1, 3, 6, 8};
        SparseTable st = new SparseTable(arr);
        System.out.println("Minimum of range 2 to 5 : " + st.rangeMin(2, 5));
        System.out.println("Maximum of range 3 to 7 : " + st.rangeMax(3, 7));
    }
}