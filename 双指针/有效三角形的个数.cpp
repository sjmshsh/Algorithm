// 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。

 // https://leetcode.cn/problems/valid-triangle-number/
class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        // 进行排序
        sort(nums.begin(), nums.end());
        int ret = 0;
        int N = nums.size();
        // 先固定住最大的边
        for (int i = N - 1; i >= 2; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    ret += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        return ret;
    }
};
