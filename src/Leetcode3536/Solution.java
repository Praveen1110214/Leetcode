package Leetcode3536;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int n = 128;
        System.out.println(new Solution().maxProduct(n));
    }
    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();
        while(n != 0) {
            int digit = n % 10;
            list.add(digit);
            n /= 10;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size() - 1; i++) {
            for(int j = i + 1; j < list.size(); j++) {
                max = Math.max(max, list.get(i) * list.get(j));
            }
        }
        return max;
    }
}
