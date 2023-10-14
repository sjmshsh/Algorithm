class Solution {
public:
    // 问题转换成将一堆stone放进最大容量为sum/2的背包, 求放进去的石头的最大重量MaxWeight
    int lastStoneWeightII(vector<int>& stones) {
        int n = stones.size();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
        vector<int> dp(target + 1);
        // 外层遍历石头数组
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        return sum - 2 * dp[target];
    }
};
