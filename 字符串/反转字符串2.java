// 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 

// 链接：https://leetcode.cn/problems/reverse-string-ii

class Solution {

    public void Swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    public void Reverse(char[] s, int left, int right) {
        while (left < right) {
            Swap(s, left, right);
            left++;
            right--;
        }
    }

    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        int N = str.length;
        // for循环每次增加2*k
        for (int i = 0; i < N; i += 2*k) {
            int r = i + k - 1;
            Reverse(str, i, Math.min(r, N - 1));
        }
        return String.valueOf(str);
    }
}
