// 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

// candidates 中的每个数字在每个组合中只能使用 一次 。

// 注意：解集不能包含重复的组合。 

// 链接：https://leetcode.cn/problems/combination-sum-ii

class Solution {

    public List<List<Integer>> result = new ArrayList<>();
    public List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int N = candidates.length;
        Arrays.sort(candidates);
        combinationSum2Core(candidates, target, 0);
        return result;
    }

    public void combinationSum2Core(int[] candidates, int target, int index) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            target -= candidates[i];
            temp.add(candidates[i]);
            combinationSum2Core(candidates, target, i + 1);
            target += candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}
