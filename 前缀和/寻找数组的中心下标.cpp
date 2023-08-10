// 给你一个整数数组 nums ，请计算数组的 中心下标 。

// 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。

// 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。

// 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。

 class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int n = nums.size();
        vector<int> lsum(n), rsum(n);
        // 计算左边的前缀和
        for (int i = 1; i < n; i++) {
            lsum[i] = lsum[i - 1] + nums[i - 1];
        }
        // 计算右边的前缀和
        for (int i = n - 2; i >= 0; i--) {
            rsum[i] = rsum[i + 1] + nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (lsum[i] == rsum[i]) {
                return i;
            }
        }
        return -1;
    }
};
