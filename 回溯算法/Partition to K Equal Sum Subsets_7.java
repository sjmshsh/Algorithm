// 很强大的剪枝
class Solution {
    // 备忘录，记录选择的正确与否的状态
    private Map<Integer, Boolean> map = new HashMap<>();
    // 桶选择球的思路，这种思路在有些情况下效率高，但是有些情况下效率也是很低下的
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int N = nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++) sum += nums[i];
        if (sum % k != 0) return false;
        int target = sum / k;
        int used = 0;
        int[] buckets = new int[k];
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
        return canPartitionKSubsetsCore(nums, k - 1, target, 0, buckets, used);
    }

    public boolean canPartitionKSubsetsCore(int[] nums, int k, int target, int start, int[] buckets,int used) {
        if (k == -1) return true; // 如果所有的桶都已经装完了，说明就已经结束了，是正确的

        // 当桶装满的时候，从下一个桶开始装
        if (buckets[k] == target) {
            Boolean res = canPartitionKSubsetsCore(nums, k - 1, target, 0, buckets, used);
            map.put(used, res); // 把状态保存下来
            return res;
        }
        // 如果这个状态已经计算过了，我们就不再进行计算了, 直接返回结果
        if (map.containsKey(used)) {
            return map.get(used);
        }

        // 桶选球的过程
        for (int i = start; i < nums.length; i++) {
            // 如果当前这个球已经被装过了, 就直接跳过，不可以继续装这个球了
            // 这个条件必须要写在前面
            if (((used >> i) & 1) == 1) continue;
            if (nums[i] + buckets[k] > target) continue;
            buckets[k] += nums[i];
            used |= 1 << i;
            if (canPartitionKSubsetsCore(nums, k, target, i + 1, buckets, used)) return true;
            buckets[k] -= nums[i];
            used ^= 1 << i;
            // 如果下一个的值也是一样的话，那么下一个也一定不行，直接跳过
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return false;
    }
}
