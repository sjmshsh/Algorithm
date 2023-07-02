//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
//你返回所有和为 0 且不重复的三元组。
//注意：答案中不可以包含重复的三元组。

//链接：https://leetcode.cn/problems/3sum

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        // 排序
        sort(nums.begin(), nums.end());
        int n = nums.size();
        vector<vector<int>> res;
        // 固定第一个数字
        for (int i = 0; i < n; i++) {
            // 第一个数字去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                // 第二个数字去重
                while (left > i + 1 && left < n && nums[left] == nums[left - 1]) {
                    left++;
                }
                if (left >= right) {
                    break;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.push_back({nums[i], nums[left], nums[right]});
                    // 这里要注意，left++
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }
};
