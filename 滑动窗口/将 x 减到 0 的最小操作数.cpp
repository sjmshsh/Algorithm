// 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。

// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。

// 链接：https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero

class Solution {
public:
// 找出最长子数组的长度，使得这个子数组所有元素之和为sum - x
    int minOperations(vector<int>& nums, int x) {
        int sum = 0;
        for (int e : nums) {
            sum += e;
        }
        int target = sum - x;
        // 这个地方很重要
        if (target < 0) {
            return -1;
        }
        int res = -1;
        int left = 0;
        int right = 0;
        int nsum = 0;
        while (right < nums.size()) {
            // 尝试扩大窗口
            nsum += nums[right];
            // 尝试缩小窗口
            while (nsum > target) {
                nsum -= nums[left];
                left++;
            }
            if (nsum == target) {
                res = max(res, right - left + 1);
            }
            right++;
        }
        if (res == -1) {
            return res;
        }
        return nums.size() - res;
    }
};
