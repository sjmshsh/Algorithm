class Solution {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        char[] str = s.toCharArray();
        int len = str.length;
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (str[i] != str[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i + 1 <= 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] == true && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
