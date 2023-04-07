// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


// 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number

class Solution {

    // 把下标对应起来
    public String letterMap[] = {
        "", // 0
        "", // 1
        "abc", // 2
        "def", // 3
        "ghi", // 4
        "jkl", //5
        "mno", // 6
        "pqrs", // 7
        "tuv", // 8
        "wxyz", // 9
    };

    public List<String> result = new ArrayList<>();
    public StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        letterCombinationsCore(digits, 0);
        return result;
    }

    public void letterCombinationsCore(String digits, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return ;
        }
        // 先得到数字对应的一个字符串
        String str = letterMap[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            letterCombinationsCore(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}








