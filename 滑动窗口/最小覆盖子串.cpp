// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

 class Solution {
public:
    string minWindow(string s, string t) {
        string res;
        unordered_map<char, int> need;
        for (auto ch : t) {
            need[ch]++;
        }
        unordered_map<char, int> window;
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int mini = INT_MAX;
        while (right < s.size()) {
            // 尝试扩充右边的窗口
            char l = s[right];
            right++;
            if (need.count(l)) {
                // 如果need表里面有这个数据的话
                window[l]++;
                if (window[l] == need[l]) {
                    valid++;
                }
            }
            // 尝试收缩左边的窗口
            // 判断的条件是有效的字符串个数
            // 如果有效的字符串个数达到了，就可以收缩，否则就一致扩张
            while (valid == need.size()) {
                // 先判断是否需要更新
                if (right - left < mini) {
                    start = left;
                    mini = right - left;
                }
                char ll = s[left];
                left++;
                // 如果这个值在need里面存在的话
                if (need.count(ll)) {
                    if (window[ll] == need[ll]) {
                        valid--;
                    }
                    window[ll]--;
                }
            }
        }
        if (mini == INT_MAX) {
            return "";
        }
        return s.substr(start, mini);
    }
};
