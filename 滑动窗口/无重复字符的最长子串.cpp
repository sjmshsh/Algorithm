// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// https://leetcode.cn/problems/longest-substring-without-repeating-characters/

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // 用数组模拟哈希表
        int hash[128] = {0};
        int res = 0;
        int left, right = 0;
        while (right < s.size()) {
            // 进去窗口
            hash[s[right]]++;
            // 判断是否要出窗口
            while (hash[s[right]] > 1) {
                hash[s[left]]--;
                left++;
            }
            // 更新结果
            res = max(res, right - left + 1);
            // 更新窗口
            right++;
        }
        return res;
    }
};
