class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        // 定义dp[i]的含义是：以i结尾的最长严格递增子序列的长度
        int[] dp = new int[N];
        // 填充数组，每一个地方的子序列都是1
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            // 注意这里要从0开始算起
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
