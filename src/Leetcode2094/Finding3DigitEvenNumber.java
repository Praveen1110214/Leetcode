package Leetcode2094;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finding3DigitEvenNumber {
    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4};
        System.out.println(Arrays.toString(findEvenNumber(digits)));
    }
    static int[] findEvenNumber(int[] digits){
        int[] freq = new int[10];
        for(int num : digits){
            freq[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 100; i <= 998; i += 2){
            int ones = i % 10;
            int tens = (i / 10) % 10;
            int hundreds = i / 100;
            int[] digitFreq = new int[10];
            digitFreq[ones]++;
            digitFreq[tens]++;
            digitFreq[hundreds]++;
            boolean valid = true;
            for(int j = 0; j < 10; j++){
                if(digitFreq[j] > freq[j]){
                    valid = false;
                    break;
                }
            }
            if(valid) result.add(i);
        }
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
