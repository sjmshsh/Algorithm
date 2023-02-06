// 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

// 数组中的每个元素代表你在该位置可以跳跃的最大长度。

// 判断你是否能够到达最后一个下标。

// https://leetcode.cn/problems/jump-game/

class Solution {
    public boolean canJump(int[] nums) {
        int N = nums.length;
        // 定义一个变量表示最远距离
        int farthest = 0;
        // 这里需要注意，因为题目说的是能够跳到最后一个下标，所以这里是i < N - 1
        for (int i = 0; i < N - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) {
                return false;
            }
        }
        return farthest >= N - 1;
    }
}
