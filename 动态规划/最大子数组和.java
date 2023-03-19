// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
// 子数组 是数组中的一个连续部分。

// https://leetcode.cn/problems/maximum-subarray/

class Solution {
    public int maxSubArray(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < N; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }
}
