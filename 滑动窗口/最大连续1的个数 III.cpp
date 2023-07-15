// 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
// https://leetcode.cn/problems/max-consecutive-ones-iii/

class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int res = 0;
        int left = 0;
        int right = 0;
        int zero = 0; // 这个变量记录的是窗口内0的个数，最多只能由k个
        while (right < nums.size()) {
            if (nums[right] == 0) {
                zero++;
            }
            // 判断左边的指针是否需要出窗口
            while (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            res = max(res, right - left + 1);
            right++;
        }
        return res;
    }
};
