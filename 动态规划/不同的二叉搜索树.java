// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

// https://leetcode.cn/problems/unique-binary-search-trees/

class Solution {
    public int numTrees(int n) {
        // dp[i]的含义：当树的序列长度为i的时候，有多少种二叉搜索树
        int[] dp = new int[n + 1];
        dp[0] = 1; // 空树，也算一种
        dp[1] = 1; // 只有一个节点的树，单节点，算一种
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
