import java.util.HashMap;
import java.util.Map;

public class CountAnagrams {
    public static void main(String[] args) {
        String pat = "for";
        String text = "rofadforofrfro";
        System.out.println(countOccurrences(pat, text));
    }
    static int countOccurrences(String pat, String text){
        Map<Character, Integer> patMap = new HashMap<>();
        Map<Character, Integer> textMap = new HashMap<>();
        int patLength = pat.length();
        int textLength = text.length();
        int count = 0;
        for(int i = 0; i < patLength; i++){
            char patChar = pat.charAt(i);
            patMap.put(patChar, patMap.getOrDefault(patChar, 0) + 1);
        }
        for(int i = 0; i < patLength; i++){
            char ch = text.charAt(i);
            textMap.put(ch, textMap.getOrDefault(ch, 0) + 1);
        }
        if(patMap.equals(textMap)) count++;
        for(int i = patLength; i < textLength; i++){
            char oldChar = text.charAt(i - patLength);
            char newChar = text.charAt(i);
            textMap.put(newChar, textMap.getOrDefault(newChar, 0) + 1);
            textMap.put(oldChar, textMap.getOrDefault(oldChar, 0) - 1);
            if(textMap.get(oldChar) == 0) textMap.remove(oldChar);
            if(textMap.equals(patMap)) count++;
        }
        return count;
    }
}
