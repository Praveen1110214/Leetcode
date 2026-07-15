package Leetcode119;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public static void main(String[] args) {
        int numRow = 5;
        System.out.println(getRow(numRow));
    }
    static List<Integer> getRow(int numRow){
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for(int i = 1; i <= numRow; i++){
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int j = 1; j < i; j++){
                newRow.add(row.get(j - 1) + row.get(j));
            }
            newRow.add(1);
            row = newRow;
        }
        return row;
    }
}
