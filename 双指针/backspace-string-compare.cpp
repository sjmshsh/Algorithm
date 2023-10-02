// https://leetcode.cn/problems/backspace-string-compare/

class Solution {
public:
    bool backspaceCompare(string s, string t) {
        return delBackSpace(s) == delBackSpace(t);
    }

    string delBackSpace(string s) {
        int n = s.size();
        int slow = 0;
        int fast = 0;     
        while (fast < n) {
            if (s[fast] != '#') {
                s[slow++] = s[fast];
            } else if (slow > 0) {
                slow--;
            }
            fast++;
        }
        return s.substr(0, slow);
    }
};
