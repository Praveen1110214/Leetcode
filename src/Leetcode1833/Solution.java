package Leetcode1833;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] costs = {1,3,2,4,1};
        int coins = 5;
        System.out.println(new Solution().maxIceCream(costs, coins));
    }
    public int maxIceCream(int[] costs, int coins){
        int maxIcecream = 0;
        Arrays.sort(costs);
        for(int cost : costs){
            if(coins - cost >= 0){
                maxIcecream++;
                coins -= cost;
            } else {
                break;
            }
        }
        return maxIcecream;
    }
}
