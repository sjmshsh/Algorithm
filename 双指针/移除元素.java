// 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

// 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

// 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

// 链接：https://leetcode.cn/problems/remove-element

class Solution {
    public int removeElement(int[] nums, int val) {
        int N = nums.length;
        int slow = 0; // 慢指针
        int fast = 0; // 快指针
        // 每次都需要把快指针指向的值赋值给慢指针
        // 遇到val的值的时候，慢指针不懂，快指针++
        while (fast < N) {
            if (nums[fast] != val) {
                // 如果此时快指针指到了
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
