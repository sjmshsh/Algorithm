// https://leetcode.cn/problems/daily-temperatures/

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        // 递增栈
        // 题目的要求是求更高温度
        // 我们需要使用递增循序(栈头到栈底的顺序), 因为只有递增的时候, 栈里面要加入一个元素i的时候,
        // 才知道栈顶元素在数组中国右边第一个比栈顶元素大的元素是i
        // stack里面存放在是下标
        stack<int> st;
        int N = temperatures.size();
        vector<int> result(N, 0);
        for (int i = 0; i < N; i++) {
            // 题目说的是更高的温度，因此这个地方不可以写等于号
            while (!st.empty() && temperatures[st.top()] < temperatures[i]) {
                int k = st.top();
                st.pop();
                int x = i - k; // 算出在几天后
                result[k] = x;
            }
            // 每次需要填充新的数据进去
            st.push(i);
        }
        // 此时栈里面可能还有值，这个时候表名不可能有值更大了，因此全部弹出，并且赋值为0即可
        while (!st.empty()) {
            int k = st.top();
            st.pop();
            result[k] = 0;
        }
        return result;
    }
};
