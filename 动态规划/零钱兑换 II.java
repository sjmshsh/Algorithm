// 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。

// 假设每一种面额的硬币有无限个。 

// 题目数据保证结果符合 32 位带符号整数。

// 链接：https://leetcode.cn/problems/coin-change-ii

class Solution {
    // 看到这句话
    // 假设每一种面额的硬币有无限个。 
    // 完全背包问题
    public int change(int amount, int[] coins) {
        int N = coins.length;
        // dp[i]的含义为：有dp[i]种硬币组合数可以凑出金额i
        int[] dp = new int[amount + 10];
        
        // 当amount为0的时候，有1种组合方法可以凑出总金额
        dp[0] = 1;
        
        // 穷举硬币的面额
        for (int i = 0; i < N; i++) {
            // 穷举amount
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        
        return dp[amount];
    }
}
