class Solution {
public:
    string longestPalindrome(string s) {
        string res = "";
        for (int i = 0; i < s.size(); i++) {
            // 以s[i]为中心的最长回文子串
            string s1 = palindrom(s, i, i);
            // 以s[i]和s[i+1]为中心的最长回文子串
            string s2 = palindrom(s, i, i + 1);
            res = res.size() > s1.size() ? res : s1;
            res = res.size() > s2.size() ? res : s2;
        }
        return res;
    }

    // 在s中寻找以s[l]和s[r]为中心的最长回文串
    string palindrom(string s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.size() && s[l] == s[r]) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以s[l]和s[r]为中心的最长回文串
        return s.substr(l + 1, r - l + 1 - 2);
    } 
};
