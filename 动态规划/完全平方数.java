// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

// 链接：https://leetcode.cn/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
        // 定义dp[i]：和为i的完全平方数的最少数量
        int[] dp = new int[n + 10];
        // 这里要记得填充一下最大值，因为我们求的是最少
        Arrays.fill(dp, n + 10);
        // 和为0的完全平方数的最少数量是1
        dp[0] = 0;
        // 遍历和的值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                // 这里要注意是i，不是j。内循环只是用来遍历所有情况的
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
