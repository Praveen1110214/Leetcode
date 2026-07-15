import java.util.Arrays;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboao";
        System.out.println(checkInclusion(s1, s2));
    }
    static boolean checkInclusion(String s1, String s2){
        int k = s1.length();
        int n = s2.length();
        if(n < k) return false;
        int[] patternFreq = new int[26];
        for(int i = 0; i < k; i++){
            patternFreq[s1.charAt(i) - 'a']++;
        }
        int[] windowFreq = new int[26];
        for(int i = 0; i < k; i++){
            windowFreq[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(patternFreq, windowFreq)) return true;
        for(int right = k; right < n; right++){
            windowFreq[s2.charAt(right - k) - 'a']--;
            windowFreq[s2.charAt(right) - 'a']++;
            if(Arrays.equals(windowFreq, patternFreq)) return true;
        }
        return false;
    }
}
