class Solution {
public:
    bool IsPopOrder(vector<int> pushV,vector<int> popV) {
        if(pushV.size() == 0 || popV.size() == 0 || pushV.size() != popV.size())
        {
            return false;
        }
        int i = 0;//pushV的
        int j = 0;//popV的
        stack<int> st;
        while(i < pushV.size())
        {
            //不bb那么多，先加上再说
            st.push(pushV[i]);
            i++;
            //这个时候考虑是否是删除
            while(!st.empty() && st.top() == popV[j])//删完，全部去掉
            {
                st.pop();
                j++;
            }
        }
        return j == popV.size();
    }
};
