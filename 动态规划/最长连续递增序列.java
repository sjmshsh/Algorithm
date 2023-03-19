// 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

// 链接：https://leetcode.cn/problems/longest-continuous-increasing-subsequence

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int N = nums.length;
        // 定义dp[i]的含义是以i结尾的最长连续子序列长度
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
