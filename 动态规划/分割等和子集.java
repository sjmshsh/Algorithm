// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

// https://leetcode.cn/problems/partition-equal-subset-sum/

class Solution {
    public boolean canPartition(int[] nums) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target + 10];
        // 开始01背包问题，照猫画虎的搞就可以了
        for (int i = 0; i < N; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        if (dp[target] == target) {
            return true;
        }
        return false;
    }
}
