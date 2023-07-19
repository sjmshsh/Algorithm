//你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。

//你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：

//你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
//你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
//一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
//给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。

//链接：https://leetcode.cn/problems/fruit-into-baskets

class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int res = 0;
        int left = 0;
        int right = 0;
        unordered_map<int, int> window;
        while (right < fruits.size()) {
            // 尝试更新右侧窗口
            window[fruits[right]]++;
            // 尝试收缩窗口
            while (window.size() > 2) {
                window[fruits[left]]--;
                if (window[fruits[left]] == 0) {
                    window.erase(fruits[left]);
                }
                left++;
            }
            // 更新答案
            res = max(res, right - left + 1);
            right++;
        }
        return res;
    }
};
