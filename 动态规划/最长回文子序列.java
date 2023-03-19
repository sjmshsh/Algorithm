// 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

 
// 链接：https://leetcode.cn/problems/longest-palindromic-subsequence

class Solution {
    public int longestPalindromeSubseq(String s) {
        int N = s.length();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][N - 1];
    }
}
