// 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 // https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        vector<int> res;
        unordered_map<char, int> need, window;
        for (char t : p) {
            need[t]++;
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.size()) {
            // 尝试扩张窗口
            char ch = s[right];
            right++;
            if (need.count(ch)) {
                // 如果这个字母在need窗口里面是有的
                window[ch]++;
                if (window[ch] == need[ch]) {
                    valid++;
                }
            }
            // 判断左侧窗口是否需要收缩
            while ((right - left + 1) > p.size()) {
                // 如果窗口的大小大于p字符串的长度, 那么就说明窗口需要收缩了
                // 先查看是否可以添加到结果集
                if (valid == need.size()) {
                    res.push_back(left);
                }
                char l = s[left];
                left++;
                if (need.count(l)) {
                    if (window[l] == need[l]) {
                        valid--;
                    }
                    window[l]--;
                }
            }
        }
        return res;
    }
};
