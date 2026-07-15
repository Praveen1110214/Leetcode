public class DecodeWays {

    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    static int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return decode(s, 0, dp);
    }

    static int decode(String s, int index, Integer[] dp) {

        // Successfully decoded the whole string
        if (index == s.length()) {
            return 1;
        }

        // Invalid path
        if (s.charAt(index) == '0') {
            return 0;
        }

        // Already computed
        if (dp[index] != null) {
            return dp[index];
        }

        // Choice 1: Take one digit
        int ways = decode(s, index + 1, dp);

        // Choice 2: Take two digits if valid
        if (index + 1 < s.length()) {

            int value = (s.charAt(index) - '0') * 10
                    + (s.charAt(index + 1) - '0');

            if (value >= 10 && value <= 26) {
                ways += decode(s, index + 2, dp);
            }
        }

        dp[index] = ways;
        return ways;
    }
}