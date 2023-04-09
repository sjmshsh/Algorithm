class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int N = text1.length();
        int M = text2.length();
        // 定义dp[i][j]的含义是：text1的前i个字符和text2的前j个字符组成的最长公共子序列长度
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[N][M];
    }
}
