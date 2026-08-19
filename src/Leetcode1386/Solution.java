package Leetcode1386;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int n = 2;
        int[][] reservedSeats = {{2, 1}, {1, 8}, {2, 6}};
        System.out.println(new Solution().maxNumberOfFamilies(n, reservedSeats));
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> rowReservations = new HashMap<>();
        for(int[] reservation : reservedSeats) {
            int row = reservation[0];
            int seatNumber = reservation[1];
            rowReservations.merge(row, 1 << (10 - seatNumber),
                    (existingBit, newBit) -> existingBit | newBit);
        }
        int leftGroupMask = 0b0111100000;
        int rightGroupMask = 0b0000011110;
        int middleGroupMask = 0b0001111000;
        int[] groupMasks = {leftGroupMask, rightGroupMask, middleGroupMask};
        int totalFamilies = (n - rowReservations.size()) * 2;
        for(int reservedSeatsBitMask : rowReservations.values()) {
            for(int groupMask : groupMasks) {
                if((reservedSeatsBitMask & groupMask) == 0) {
                    reservedSeatsBitMask |= groupMask;
                    totalFamilies++;
                }
            }
        }
        return totalFamilies;
    }
}
