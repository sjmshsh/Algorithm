// 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：

// 只使用数字1到9
// 每个数字 最多使用一次 
// 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。

 
// 链接：https://leetcode.cn/problems/combination-sum-iii

class Solution {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3Core(k, n, 1, 0);
        return result;
    }

    // k个数字
    // 相加之和为n
    public void combinationSum3Core(int k, int targetSum, int start, int sum) {
        if (sum > targetSum) {
            return;
        }
        if (path.size() == k) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            sum += i;
            path.add(i);
            combinationSum3Core(k, targetSum, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}
