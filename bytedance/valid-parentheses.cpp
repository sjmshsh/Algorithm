class Solution {
public:
    bool isValid(string s) {
        stack<char> left;
        for (char c : s) {
            if (c == '(' || c == '{' || c == '[') {
                left.push(c);
            } else {
                // 字符c是右括号
                if (!left.empty() && leftOf(c) == left.top()) {
                    left.pop();
                } else {
                    // 说明和左括号已经不匹配了
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }

    char leftOf(char c) {
        if (c == '}') return '{';
        if (c == ')') return '(';
        return '[';
    }
};
