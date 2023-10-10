class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0;
        // 用变量保存左边当前的最大值和右边当前的最大值
        int leftMaxValue = 0;
        int rightMaxValue = 0;
        // 定义左右指针
        int left = 0;
        int right = height.size() - 1;
        while (left < right) {
            leftMaxValue = max(leftMaxValue, height[left]);
            rightMaxValue = max(rightMaxValue, height[right]);

            if (height[left] < height[right]) {
                // 说明最高就只能到达左边的这个位置
                ans += (leftMaxValue - height[left]);
                left++;
            } else {
                ans += (rightMaxValue - height[right]);
                right--;
            }
        }
        return ans;
    }
};
