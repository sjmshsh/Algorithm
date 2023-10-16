class Solution {
public:
    // 单调栈, 栈的最上面的数字是最小的
    int trap(vector<int>& height) {
        int n = height.size();
        int res = 0;
        stack<int> st;
        for (int i = 0; i < n; i++) {
            while (!st.empty() && height[i] > height[st.top()]) {
                int x = st.top();
                st.pop();
                if (st.empty()) break;
                int l = st.top();
                int width = i - l + 1 - 2;
                int h = min(height[l], height[i]) - height[x];
                res += h * width;
            }
            st.push(i);
        }
        return res;
    }
};
