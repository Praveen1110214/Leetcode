public class Leetcode2309 {
    public static void main(String[] args) {
        String word = "arRAzFif";
        System.out.println(greatestLetter(word));
    }
    static String greatestLetter(String s){
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                lower[ch - 'a'] = true;
            } else {
                upper[ch - 'A'] = true;
            }
        }
        for(int i = 25; i >= 0; i--){
            if(lower[i] && upper[i]){
                return String.valueOf((char)(i + 'A'));
            }
        }
        return "";
    }
}
