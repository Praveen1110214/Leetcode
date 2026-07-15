package Leetcode1337;

import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]
        );
        for(int i = 0; i < mat.length; i++){
            int soldiersCount = countSoldiers(mat[i]);
            queue.offer(new int[]{i, soldiersCount});
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = queue.poll()[0];
        }
        return res;
    }
    private int countSoldiers(int[] row){
        int left = 0;
        int right = row.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(row[mid] == 1) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
