package Leetcode914;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < deck.length; i++){
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);
        }
        int gcd = 0;
        for(int count : map.values()) {
            gcd = findGCD(gcd, count);
        }
        return gcd >= 2;
    }
    private int findGCD(int a, int b){
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
