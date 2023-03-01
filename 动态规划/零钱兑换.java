// 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

// 你可以认为每种硬币的数量是无限的。

// 链接：https://leetcode.cn/problems/coin-change

class Solution {
    // 看到这句话
    // 你可以认为每种硬币的数量是无限的。
    // 可以想到是完全背包问题
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        // 定义dp[i]的含义是：组成金额i需要的最少的硬币个数是dp[i]
        int[] dp = new int[amount + 10];
        // 填充dp里面的值，如果值是amount + 2，那么就代表无法组成amount这个金额
        Arrays.fill(dp, amount + 2);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
        return dp[amount] == (amount + 2) ? -1 : dp[amount];
    }
}
