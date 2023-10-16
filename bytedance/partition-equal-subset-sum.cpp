class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int N = nums.size();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
        }
        // 如果%2不是0的话说明直接就错误了
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // dp[j]的含义是dp的这个背包里面拿到了j的东西
        vector<int> dp(target + 10);

        // 开始01背包问题
        for (int i = 0; i < N; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        if (dp[target] == target) return true;
        return false;
    }
};
