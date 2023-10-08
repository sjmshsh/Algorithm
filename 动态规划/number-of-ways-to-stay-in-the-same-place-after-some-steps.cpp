// https://leetcode.cn/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/

class Solution {
public:

    const int mod = 1000000007;

    int numWays(int steps, int arrLen) {
        int maxColumn = min(steps, arrLen - 1);
        // dp[i][j]表示的含义是: 在移动了i步之后, 指针停留在索引为j的位置的方案数量
        vector<vector<int>> dp(steps + 1, vector<int>(maxColumn + 1));
        dp[0][0] = 1;
        // 计算出能够到达的最远的距离
        
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % mod;
                }
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[steps][0];
    }
};
