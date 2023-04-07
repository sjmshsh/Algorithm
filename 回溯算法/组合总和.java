// 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 
// 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。

// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 

// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。

// 链接：https://leetcode.cn/problems/combination-sum

class Solution {

    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSumCore(candidates, target, 0);
        return result;
    }

    public void combinationSumCore(int[] candidates, int target, int index) {
        // 如果target直接小于0了，就直接返回，没有意义了
        if (target < 0) {
            return;
        }
        if (target == 0) {
            // 如果等于0的话 
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            target -= candidates[i];
            temp.add(candidates[i]);
            combinationSumCore(candidates, target, i);
            target += candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}
