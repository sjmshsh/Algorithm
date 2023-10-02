// https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int l = -1;
        int r = n;
        vector<int> res;
        res.push_back(find(nums, target, true));
        res.push_back(find(nums, target, false));
        return res;
    }

    int find(vector<int>& nums, int target, bool flag) {
        int n = nums.size();
        int l = -1;
        int r = n;
        if (flag) {
            // 开始位置
            while (l + 1 != r) {
                int mid = (l + r) >> 1;
                if (nums[mid] < target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (r == -1 || r == n || nums[r] != target) {
                return -1;
            } else {
                return r;
            }
        } else {
            // 结束位置
            while (l + 1 != r) {
                int mid = (l + r) >> 1;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (l == -1 || l == n || nums[l] != target) {
                return -1;
            } else {
                return l;
            }
        }
    }
};
