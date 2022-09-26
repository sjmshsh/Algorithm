// 本解法使用暴力，以球选桶为视角
class Solution {
    // 纯暴力，站在球的视角，球选择桶
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) 
            sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        int[] buckets = new int[k];
        return canPartitionKSubsetsCore(nums, k, target, 0, buckets);
    }

    // k是桶的数量, index代表我当前遍历到第几号球了
    public boolean canPartitionKSubsetsCore(int[] nums, int k, int target, int index, int[] buckets) {
        if (index == nums.length) {
            // 当我已经把所有的球全部遍历完毕的时候
            // 循环验证查看是否每一个桶都是达标的
            for (int i = 0; i < k; i++) {
                if (buckets[i] != target) return false;
            }
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (buckets[i] + nums[index] > target) continue; // 如果你的此时的桶的大小已经大于我的target了，就没有继续遍历下去的必要了，直接过下一个
            buckets[i] += nums[index];
            if (canPartitionKSubsetsCore(nums, k, target, index + 1, buckets)) return true;
            buckets[i] -= nums[index];
        }
        return false;
    }
}
