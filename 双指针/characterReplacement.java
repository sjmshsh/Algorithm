class Solution {
    public int characterReplacement(String s, int k) {
        char[] str = s.toCharArray();
        int n = str.length;
        int left = 0;
        int right = 0; // 定义两个指针
        int maxCount = 0;
        int[] flag = new int[26];
        int res = 0;
        // 我们定义的区间范围是[left, right]
        while (right < n) {
            flag[str[right] - 'A']++;
            maxCount = Math.max(maxCount, flag[str[right] - 'A']);
            right++;
            if (maxCount + k < right - left) {
                flag[str[left] - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
