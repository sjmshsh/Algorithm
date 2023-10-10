class Solution {
public:
// 遇到这种循环遍历的题目一般是拼接数组, 这里采用模拟拼接的方式
    vector<int> nextGreaterElements(vector<int>& nums) {
        int N = nums.size();
        // 先把值初始化成-1
        vector<int> res(N, -1);
        // 单调栈
        stack<int> st;
        
        for (int i = 0; i < 2*N; i++) {
            while (!st.empty() && nums[st.top()] < nums[i%N]) {
                // 得到当前的值
                int x = st.top();
                res[x] = nums[i%N];
                st.pop();
            }
            st.push(i % N); 
        }
        return res;
    }
};
