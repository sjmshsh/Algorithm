// 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

// 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。

// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

// 链接：https://leetcode.cn/problems/ones-and-zeroes

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] 表示最多有i个0和j个1的时候，最大子集的长度是dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // 对dp数组进行初始化
        dp[0][0] = 0;
        for (String str : strs) { // 遍历每一个字符串
            int zeroNum = 0;
            int oneNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            // 我已经得到了当前字符串0的数量和1的数量
            // 开始动态规划
            // 倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
