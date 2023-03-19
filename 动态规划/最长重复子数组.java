// 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。

// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int M = nums2.length;
        // 定义dp[i][j]：以i结尾和j结尾的最长公共子数组的长度
        int[][] dp = new int[N + 1][M + 1];
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; 
                }
                if (res < dp[i][j]) {
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
