// https://leetcode.cn/problems/path-sum/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    // 使用栈去模拟这个过程
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == nullptr) return false;
        stack<pair<TreeNode*, int>> st;
        st.push(pair<TreeNode*, int>(root, root->val));

        while (!st.empty()) {
            pair<TreeNode*, int> node = st.top();
            st.pop();
            // 判断是否到达了叶子节点
            if (node.first->left == nullptr && node.first->right == nullptr && node.second == targetSum) {
                return true;
            }

            // 用栈模拟递归，那么必须是先入右节点
            if (node.first->right) {
                st.push(pair<TreeNode*, int>(node.first->right, node.second + node.first->right->val));
            }

            if (node.first->left) {
                st.push(pair<TreeNode*, int>(node.first->left, node.second + node.first->left->val));
            }
        }

        return false;
    }
};
