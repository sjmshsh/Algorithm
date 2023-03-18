// 给你一个字符串 s ，请你反转字符串中 单词 的顺序。

// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。

// 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。

// 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。

// 链接：https://leetcode.cn/problems/reverse-words-in-a-string

class Solution {

    // 翻转 arr[i..j]
    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public String reverseWords(String s) {
        // 第一步去除空格，清洗数据
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                // 如果当前字符不是空格的话
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' '){
                sb.append(' ');
            }
        }
        // 如果末尾有空格就直接删了
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        char[] strs = sb.toString().toCharArray();
        int N = strs.length;
        // 将全体进行翻转
        reverse(strs, 0, N - 1);
        // 把每一个单词翻转
        for (int i = 0; i < N; ) {
            for (int j = i; j < N; j++) {
                if (j + 1 == N || strs[j + 1] == ' ') {
                    // char[i..j]是一个单词，翻转之
                    reverse(strs, i, j);
                    i = j + 2;
                    break;
                }
            }
        }
        return new String(strs);
    }
}






