package Leetcode1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {10, 20, 50, 30};
        System.out.println(Arrays.toString(new Solution().arrayRankTransform(arr)));
    }

    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        int[] temp = Arrays.copyOf(arr, n);
        Arrays.sort(temp);
        int[] ranks = new int[n];
        ranks[0] = 1;
        for (int i = 1; i < n; i++) {
            if (temp[i - 1] == temp[i]) {
                ranks[i] = ranks[i - 1];
            } else {
                ranks[i] = ranks[i - 1] + 1;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(temp[i], ranks[i]);
        }
        int[] res = new int[n];
        int i = 0;
        for (int j = 0; j < n; j++) {
            res[i] = map.get(arr[j]);
            i++;
        }
        return res;
    }

    public int[] arrayRankTransform1(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for(int num : temp) {
            if(!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }
        for(int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
