import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    static List<Integer> findAnagrams(String s, String p){
        int k = p.length();
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        int[] patternFreq = new int[26];
        int[] windowFreq = new int[26];
        if( n < k) return result;
        for(int i = 0; i < k; i++){
            patternFreq[p.charAt(i) - 'a']++;
        }
        for(int i = 0; i < k; i++){
            windowFreq[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(patternFreq, windowFreq)){
            result.add(0);
        }
        for(int right = k; right < n; right++){
            windowFreq[s.charAt(right - k) - 'a']--;
            windowFreq[s.charAt(right) - 'a']++;
            if(Arrays.equals(patternFreq, windowFreq)){
                result.add(right - k + 1);
            }
        }
        return result;
    }
}
