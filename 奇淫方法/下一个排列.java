// https://leetcode.cn/problems/next-permutation/submissions/

class Solution {

    public void Swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void Reverse(int[] nums, int i, int j) {
        int left = i;
        int right = j;
        while (left < right) {
            Swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int N = nums.length;
        // 首先从后往前查找第一个排序为升序的数对
        int i = N - 2;
        int j = N - 1;
        int k = N - 1;
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        // 走到这里来的时候, nums[i] > nums[j]，并且后面的数字必定是降序排列的
        if (i >= 0) {
            // 然后从后往前遍历找到第一个比nums[i]大的数字
            while (nums[i] >= nums[k]) {
                k--;
            }
            // 到这里的时候nums[i] < nums[k]是必定存在的
            Swap(nums, i, k);
        }
        // 这个东西一定要放在外面的，因为上面的的if可能是进不去的
        Reverse(nums, i + 1, N - 1);
    }
}



