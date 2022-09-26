class Solution {
    // 桶选择球的思路，这种思路在有些情况下效率高，但是有些情况下效率也是很低下的
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        boolean[] used = new boolean[N];
        int[] buckets = new int[k];
        return canPartitionKSubsetsCore(nums, k - 1, target, 0, buckets, used);
    }

    public boolean canPartitionKSubsetsCore(int[] nums, int k, int target, int start, int[] buckets, boolean[] used) {
        if (k == -1) return true; // 如果所有的桶都已经装完了，说明就已经结束了，是正确的
        // 当桶装满的时候，从下一个桶开始装
        if (buckets[k] == target) return canPartitionKSubsetsCore(nums, k - 1, target, 0, buckets, used);
        // 桶选球的过程
        for (int i = start; i < nums.length; i++) {
            // 如果当前这个球已经被装过了, 就直接跳过，不可以继续装这个球了
            // 这个条件必须要写在前面
            if (used[i] == true) continue;
            if (nums[i] + buckets[k] > target) continue;
            buckets[k] += nums[i];
            used[i] = true;
            if (canPartitionKSubsetsCore(nums, k, target, i + 1, buckets, used)) return true;
            buckets[k] -= nums[i];
            used[i] = false;
        }
        return false;
    }
}
