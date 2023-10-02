// https://leetcode.cn/problems/remove-element/

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        int slow = 0;
        int fast = 0;
        // 每次都需要把快指针的值赋值给慢指针，唯一不同的地方在于如果快指针遇到val了
        // 那么慢指针需要停止一次赋值操作，让快指针往后移动一个
        while (fast < nums.size()) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            // 每一轮fast指针都必须往后移动
            fast++;
        }
        return slow;
    }
};
