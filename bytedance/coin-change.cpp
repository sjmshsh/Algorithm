class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        // 定义dp[i]为凑成i的金额所需要的最少硬币个数
        vector<int> dp(amount + 1, amount + 2);
        dp[0] = 0;
        for (int i = 0; i < coins.size(); i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == (amount + 2) ? -1 : dp[amount];
    }
};
