// https://leetcode.cn/problems/intersection-of-two-arrays/

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> result; // 存放结果，之所以用set是为了去重
        unordered_set<int> nums_set(nums1.begin(), nums1.end());
        for (int num : nums2) {
            // 如果nums_set里面的元素在nums2里面又出现了，那么就不进行插入了
            if (nums_set.find(num) != nums_set.end())
                result.insert(num);
        }
        return vector<int>(result.begin(), result.end());
    }
};
