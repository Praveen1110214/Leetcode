package Leetcode2259;

public class Solution {
    public static void main(String[] args) {
        String number = "4234";
        char digit = '4';
        System.out.println(new Solution().removeDigit(number, digit));
    }
    public String removeDigit(String number, char digit) {
        String newString;
        String max = "";
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == digit) {
                newString = number.substring(0, i).concat(number.substring(i + 1));
                if(max.isEmpty()){
                    max = newString;
                    continue;
                }
                for(int ch = 0; ch < newString.length(); ch++) {
                    if(newString.charAt(ch) > max.charAt(ch)) {
                        max = newString;
                    } else if (max.charAt(ch) > newString.charAt(ch)) {
                        break;
                    }
                }
            }
        }
        return max;
    }
    public String removeDigit1(String number, char digit) {
        int j=-1;
        for(int i=0; i<number.length(); i++){
            if(number.charAt(i)==digit){
                j=i;

                if(i+1<number.length() && number.charAt(i+1)>digit){
                    break;
                }
            }

        }

        return number.substring(0, j)+ number.substring(j+1);
    }
}
