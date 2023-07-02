// 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
// https://leetcode.cn/problems/he-wei-sde-liang-ge-shu-zi-lcof/

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int n = nums.size();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] == target) {
                return {nums[left], nums[right]};
            } else {
                right--;
            }
        }
        return {};
    }
};
