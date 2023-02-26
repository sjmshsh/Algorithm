class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        // pos 设为正数
        // neg = sum - pos
        // pos - neg = target
        // pos - sum + pos = target
        int goal = (target + sum) / 2;
        if (Math.abs(target) > sum || (target + sum) % 2 != 0) {
            return 0;
        }
        // dp[i]的含义是: 当前的和为i的时候，有多少种运算结果等于target的表达式
        int[] dp = new int[1010];
        // 一定要记得初始化dp数组
        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for(int j = goal; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[goal];
    }
}
