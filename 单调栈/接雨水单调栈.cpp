// https://leetcode.cn/problems/trapping-rain-water/description/

class Solution {
public:
    int trap(vector<int>& height) {
        int ans = 0;
        stack<int> st;
        int n = height.size();
        for (int i = 0; i < n; i++) {
            while (!st.empty() && height[st.top()] < height[i]) {
                int x = st.top(); // 得到当前找到的元素
                st.pop();
                if (st.empty()) {
                    break; // 如果pop完了之后st为空, 那么说明左边没有更小的了。自己就是最大的，因此无法装水，直接break
                }
                // 计算宽度
                int l = st.top();
                // 去掉两个柱子
                int width = i - l - 2 + 1;
                // 计算高度
                int h = min(height[i], height[l]) - height[x];
                ans += width * h;
            }
            st.push(i);
        }
        return ans;
    }
};
