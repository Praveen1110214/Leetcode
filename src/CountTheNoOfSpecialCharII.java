import java.util.Arrays;

public class CountTheNoOfSpecialCharII {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }
    static int numberOfSpecialChars(String word){
        int count = 0;
        int[] firstOccurrence = new int[26];
        int[] lastOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);
        Arrays.fill(lastOccurrence, -1);
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                lastOccurrence[ch - 'a'] = i;
            } else {
                if(firstOccurrence[ch - 'A'] == -1){
                    firstOccurrence[ch - 'A'] = i;
                }
            }
        }
        for(int i = 0; i < 26; i++){
            if(firstOccurrence[i] != -1 && lastOccurrence[i] != -1 && lastOccurrence[i] < firstOccurrence[i]){
                count++;
            }
        }
        return count;
    }
}
