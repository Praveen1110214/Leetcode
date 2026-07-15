package Leetcode383;

public class Solution {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(new Solution().canConstruct(ransomNote, magazine));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteFrequency = new int[26];
        int[] magazineFrequency = new int[26];
        for(int i = 0; i < ransomNote.length(); i++){
            ransomNoteFrequency[ransomNote.charAt(i) - 'a']++;
        }
        for(int i = 0; i < magazine.length(); i++){
            magazineFrequency[magazine.charAt(i) - 'a']++;
        }
//        for(char ch : ransomNote.toCharArray()) {
//            ransomNoteFrequency[ch - 'a']++;
//        }
//        for(char ch : magazine.toCharArray()) {
//            magazineFrequency[ch - 'a']++;
//        }
        for(int i = 0; i < 26; i++) {
            if(ransomNoteFrequency[i] > magazineFrequency[i]){
                return false;
            }
        }
        return true;
    }
}
