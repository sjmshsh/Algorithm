// 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

// 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> res(n);
        vector<int> lsum(n), rsum(n);
        lsum[0] = 1;
        rsum[n - 1] = 1;
        // 计算左边的前缀乘积, [0, i - 1]
        for (int i = 1; i < n; i++) {
            lsum[i] = lsum[i - 1] * nums[i - 1];
        }
        // 右边, [i + 1, n]
        for (int i = n - 2; i >= 0; i--) {
            rsum[i] = rsum[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = lsum[i] * rsum[i];
        }
        return res;
    }
};
