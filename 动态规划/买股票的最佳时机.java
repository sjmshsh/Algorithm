// 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

// 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        // 设dp[i][0]表示第i天持有股票的最大利润
        // 设dp[i][1]表示第i天不持有股票的最大利润
        int[][] dp = new int[N + 1][2];
        dp[0][1] = 0;
        dp[0][0] = -prices[0];
        for (int i = 1; i < N; i++) {
            // 第i天持有股票
            // 第i天持有股票相当于第i - 1天就已经持有股票了，或者了第
            // i - 1天没有持有股票，但是我第i天购买了股票
            dp[i][0] = Math.max(dp[i - 1][0], - prices[i]);
            // 第i天不持有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        // 求的肯定是最后一天不持有股票的
        return Math.max(dp[N - 1][1], dp[N - 1][0]);
    }
}
