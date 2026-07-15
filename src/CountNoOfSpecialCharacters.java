public class CountNoOfSpecialCharacters {
    public static void main(String[] args) {
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialCharacters(word));
    }
    static int numberOfSpecialCharacters(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(letter >= 'a' && letter <= 'z'){
                lower[letter - 'a'] = true;
            } else {
                upper[letter - 'A'] = true;
            }
        }
        int count = 0;
        for(int i = 0; i < 26; i ++){
            if(lower[i] && upper[i]){
                count++;
            }
        }
        return count;
    }
}
