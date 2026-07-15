package Leetcode1566;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;
        for(int start = 0; start + m * k <= n; start++) {
            int repeat = 1;
            while(repeat < k) {
                boolean same = true;
                for(int j = 0; j < m; j++) {
                    if(arr[start + j] != arr[start + repeat * m + j]) {
                        same = false;
                        break;
                    }
                }
                if(!same) break;
                repeat++;
            }
            if(repeat == k) return true;
        }
        return false;
    }
}
