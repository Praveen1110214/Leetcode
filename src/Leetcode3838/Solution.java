package Leetcode3838;

public class Solution {
    public static void main(String[] args) {
        String[] words = {"abcd","def","xyz"};
        int[] weights = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println(mapWordWeights(words, weights));
    }
    static String mapWordWeights(String[] words, int[] weights){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            int sum = 0;
            String word = words[i];
            for(char ch : word.toCharArray()){
                sum += weights[ch - 'a'];
            }
            sum %= 26;
            char character = (char) ('z' - sum);
            sb.append(character);
        }
        return sb.toString();
    }
}
