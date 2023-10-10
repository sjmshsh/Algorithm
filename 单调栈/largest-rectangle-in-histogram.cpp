// https://leetcode.cn/problems/largest-rectangle-in-histogram/

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n = heights.size();
        int ans = 0;
        // 单调栈里面保存的是栈顶是最大, 我们需要找的是第一个比我小的
        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && heights[st.top()] >= heights[i]) {
                // 获取当前位置
                int x = st.top();
                st.pop();
                int l = st.empty() ? -1 : st.top();
                // 计算宽度
                int width = i - l + 1 - 2;
                // 计算高度
                int h = heights[x];
                ans = max(ans, width*h);
            }
            st.push(i);
        }
        while (!st.empty()) {
            int x = st.top();
            st.pop();
            int l = st.empty() ? -1 : st.top();
            int width = n - l + 1 - 2;
            int h = heights[x];
            ans = max(ans, width*h);
        }
        return ans;
    }
};
