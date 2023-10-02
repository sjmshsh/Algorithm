// https://leetcode.cn/problems/minimum-size-subarray-sum/

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n = nums.size();
        int res = INT_MAX;
        int i = 0; // 滑动窗口的起始位置
        int len = 0; // 滑动窗口的长度
        int sum = 0; // 滑动窗口里面所有数组之和
        for (int j = 0; j < n; j++) {
            sum += nums[j]; // 尝试扩大窗口，将窗口的范围往右边移动
            // 尝试缩小窗口
            while (sum >= target) {
                len = j - i + 1;
                res = min(res, len);
                sum -= nums[i++];
            }
        }
        if (res == INT_MAX) {
            return 0;
        } else {
            return res;
        }
    }
};
