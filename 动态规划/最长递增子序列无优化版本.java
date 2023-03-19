// 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

// 链接：https://leetcode.cn/problems/longest-increasing-subsequence

class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        // 定义dp为以i结尾的最长的递增子序列
        int[] dp = new int[N + 1];
        // 设置初始化长度是1
        Arrays.fill(dp, 1);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
