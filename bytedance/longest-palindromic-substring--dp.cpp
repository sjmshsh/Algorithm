class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.size();
        if (n < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j]表示s[i...j]是否是回文串
        vector<vector<int>> dp(n, vector<int>(n));
        // 初始化, 所有长度为1的子串都是回文串
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 先枚举子串长度
        for (int L = 2; L <= n; L++) {
            // 枚举左边界
            for (int i = 0; i < n; i++) {
                // 由于L和i可以确定有边界
                int j = L + i - 1;
                // 如果右边界越界了, 就可以退出当前的循环了
                if (j >= n) {
                    break;
                }

                if (s[i] != s[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要dp[i][L] == true成立，就表示子串s[i...L]是回文, 此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substr(begin, maxLen);
    }
};
