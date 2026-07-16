package Leetcode3483;

import java.util.HashSet;
import java.util.Set;

public class Unique3DigitEvenNumber {
    public static void main(String[] args) {
        int[] digits = {4, 1, 2, 3};
        System.out.println(totalNumbers(digits));
    }
    static int totalNumbers(int[] digits){
        Set<Integer> set = new HashSet<>();
        int n = digits.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(i == j || j == k || k == i) continue;
                    if(digits[i] == 0 || digits[k] % 2 != 0) continue;
                    int num = (digits[i] * 100) + (digits[j] * 10) + (digits[k]);
                    set.add(num);
                }
            }
        }
        return set.size();
    }
}
