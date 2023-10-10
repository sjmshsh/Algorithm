// https://leetcode.cn/problems/integer-break/

func integerBreak(n int) int {
    // dp[i]的含义是：分拆数字i，可以得到的最大乘积是多少
    dp := make([]int, n + 1)
    dp[2] = 1
    for i := 3; i <= n; i++ {
        for j := 2; j < i; j++ {
            dp[i] = max(dp[i - j] * j, (i - j) * j)
        }
    }
    return dp[n]
}

func max(a int, b int) int {
    if a > b {
        return a
    } else {
        return b
    }
}
