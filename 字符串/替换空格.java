// 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

// https://leetcode.cn/problems/ti-huan-kong-ge-lcof/

class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                // 如果是空格的话插入%20
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
