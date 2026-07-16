public class LeetCode395 {
    public static void main(String[] args) {
        String s = "aaabbbaaaaa";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }
    static int longestSubstring(String s, int k){
       if(s.length() < k){
           return 0;
       }
       int[] freq = new int[26];
       for(int i = 0; i < s.length(); i++){
           char ch = s.charAt(i);
           freq[ch - 'a']++;
       }
       for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(freq[ch - 'a'] < k){
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);
                return Math.max(left, right);
            }
       }
       return s.length();
    }
}
