// 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

// 链接：https://leetcode.cn/problems/longest-consecutive-sequence


class Solution {
    public int longestConsecutive(int[] nums) {
        int N = nums.length;
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (set.contains(num - 1)) {
                // num 不是连续子序列的第一个，跳过
                continue;
            }
            // 说明构成递增序列
            int curLen = 1;
            int curNum = num;
            while (set.contains(curNum + 1)) {
                curLen++;
                curNum++;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }
}
