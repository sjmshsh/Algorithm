// 给你一个整数数组 nums 和一个整数 target 。

// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：

// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。

// 链接：https://leetcode.cn/problems/target-sum

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        if (sum < target || (sum - target) % 2 != 0) {
            return 0; // 说明是0种，无法构成target
        }
        int goal = (sum - target) / 2;
        int[] dp = new int[1010];
        dp[0] = 1;
        // dp[i] 表示运算结果为i的时候，有多少不同的表达式
        for (int i = 0; i < N; i++) {
            for (int j = goal; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[goal];
    }
}
