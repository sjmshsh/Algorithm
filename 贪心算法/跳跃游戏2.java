// https://leetcode.cn/problems/jump-game-ii/

class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        // 目前能够跳到的最远距离
        int max_fur = 0;
        // 用来表示区间范围
        int end = 0;
        // 表示步数
        int step = 0;
        for (int i = 0; i < N - 1; i++) {
            max_fur = Math.max(max_fur, nums[i] + i);
            if (end == i) {
                end = max_fur;
                step++;
            }
        }
        return step;
    }
}
