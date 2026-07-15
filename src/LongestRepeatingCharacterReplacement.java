import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacementSlidingWindow(s, k));
    }
    static int characterReplacementBruteForce(String s, int k) {
        int n = s.length();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int[] frequency = new int[26];
            for (int j = i; j < n; j++) {
                frequency[s.charAt(j) - 'A']++;
                int maxFrequency = 0;
                for (int x = 0; x < 26; x++) {
                    maxFrequency = Math.max(maxFrequency, frequency[x]);
                }
                int windowLength = j - i + 1;
                if (windowLength - maxFrequency <= k) {
                    answer = Math.max(answer, windowLength);
                }
            }
        }
        return answer;
    }
    static int characterReplacementSlidingWindow(String s, int k){
        int n = s.length();
        int[] freq = new int[26];
        int left = 0;
        int answer = 0;
        for(int right = 0; right < n; right++){
            char ch = s.charAt(right);
            freq[ch - 'A']++;
            int maxFrequency = 0;
            maxFrequency = Math.max(maxFrequency, freq[ch - 'A']);
            while ((right - left + 1) - maxFrequency > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            answer = Math.max(answer, (right - left + 1));
        }
        return answer;
    }
}
