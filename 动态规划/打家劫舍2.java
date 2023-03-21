// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个
// 房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

 
// 链接：https://leetcode.cn/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return nums[0];
        }
        int res1 = robRange(nums, 0, N - 2);
        int res2 = robRange(nums, 1, N - 1);
        return Math.max(res1, res2);
    }

    public int robRange(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[right];
    }
}
