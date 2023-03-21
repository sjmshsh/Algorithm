// 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果
// 两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

// 链接：https://leetcode.cn/problems/house-robber

class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return nums[0];
        }
        // 定义dp[i]的含义是：前i个房屋可以偷窃到的最高的金额
        int[] dp = new int[N + 1];
        dp[0] = nums[0]; // 前0个房间肯定是最高金额为0元
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[N - 1];
    }
}
