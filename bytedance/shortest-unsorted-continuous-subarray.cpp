class Solution {
public:
    // 方法一: 排序+双指针
    int findUnsortedSubarray(vector<int>& nums) {
        int n = nums.size();
        vector<int> cc(nums);
        sort(cc.begin(), cc.end());
        int i = 0;
        int j = n - 1;
        while (i <= j && cc[i] == nums[i]) i++;
        while (i <= j && cc[j] == nums[j]) j--;
        return j - i + 1;
    }
};
