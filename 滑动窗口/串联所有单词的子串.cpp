//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。

 //s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。

//例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
//返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。

 class Solution {
public:
    vector<int> findSubstring(string s, vector<string>& words) {
        vector<int> res;
        unordered_map<string, int> hash1;
        int len = words[0].size();
        // 保存words里面所有单词的频次
        for (auto word : words) {
            hash1[word]++;
        }
        // 执行len次
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int valid = 0;
            unordered_map<string, int> window;
            // 这里要注意的是right + len, 否则后面去可能会溢出了
            while (right < s.size()) {
                // 尝试扩充右边的窗口
                string in = s.substr(right, len);
                right = right + len;
                if (hash1.count(in)) {
                    // 如果hash1里面有这个字串的话
                    window[in]++;
                    if (window[in] == hash1[in]) {
                        valid++;
                    }
                }
                // 尝试收缩左边的窗口
                while ((right - left + 1) > len * words.size()) {
                    // 先查看是否可以添加到结果集
                    if (valid == hash1.size()) {
                        res.push_back(left);
                    }
                    string out = s.substr(left, len);
                    left = left + len;
                    if (hash1.count(out)) {
                        // 如果这个out还有的话
                        if (window[out] == hash1[out]) {
                            valid--;
                        }
                        window[out]--;
                    }
                }
            }
        }
        return res;
    }
};
