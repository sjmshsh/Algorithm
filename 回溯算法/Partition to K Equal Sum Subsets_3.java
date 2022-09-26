// 很强大的一个剪枝，但仍然是球选择桶
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
        // 降序排列，增加让大的元素先选择桶，增加被剪枝的可能性
        Arrays.sort(nums);
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return canPartitionKSubsetsCore(nums, k, target, 0, buckets);
    }

    // k是桶的数量, index代表我当前遍历到第几号球了
    public boolean canPartitionKSubsetsCore(int[] nums, int k, int target, int index, int[] buckets) {
        if (index == nums.length) {
            // 如果我们能够到达这一步的话，那么一定是满足条件的，因为每一个桶需要装的值我们实际上已经固定了，如果中间有东西超过范围的话，就一定到达不了这里
            return true;
        }
        for (int i = 0; i < k; i++) {
          // 如果我们上一个桶和这一个桶的大小是一样的话，那么这个球不管选择哪个桶，结果都是一样的，我们规定选择第一个桶，所以当轮到第二个桶的时候直接跳过
            if (i > 0 && buckets[i] == buckets[i - 1]) continue;
            if (buckets[i] + nums[index] > target) continue; // 如果你的此时的桶的大小已经大于我的target了，就没有继续遍历下去的必要了，直接过下一个
            buckets[i] += nums[index];
            if (canPartitionKSubsetsCore(nums, k, target, index + 1, buckets)) return true;
            buckets[i] -= nums[index];
        }
        return false;
    }
}
