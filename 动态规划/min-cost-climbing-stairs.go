// https://leetcode.cn/problems/min-cost-climbing-stairs/

func minCostClimbingStairs(cost []int) int {
    n := len(cost)
    // dp[i]表示爬到第i级台阶所需的最低花费
    dp := make([]int, n + 1)
    dp[0] = 0
    dp[1] = 0
    for i := 2; i <= n; i++ {
        dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
    }
    return dp[n]
}

func min(a int, b int) int {
    if a < b {
        return a
    } else {
        return b
    }
}
