class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int N = nums.length;
        int[] dp = new int[N];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
        }
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
