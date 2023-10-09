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
    bool hasPathSum(TreeNode* root, int targetSum) {
        if (root == nullptr) return false; // 由于树是空的, 所以根本不存在根节点到叶子节点的路径
        return traversal(root, targetSum - root->val); /*这个地方注意一下，root本身已经要去计算了*/
    }

    bool traversal(TreeNode* cur, int count) {
        // 判断是否遇到了叶子节点
        if (cur->left == nullptr && cur->right == nullptr && count == 0) {
            return true;
        }
        if (cur->left == nullptr && cur->right == nullptr) {
            // 遇到了业务节点, 但是count不为0, 也就是count不是targetSum
            return false;
        }
        // 因为我们的判断条件是业务节点，所以这边在遍历的时候就不让叶子节点为空了
        if (cur->left) {
            count -= cur->left->val;
            if (traversal(cur->left, count)) {
                return true; // 如果这个函数返回true的话, 那么这个地方也紧跟着返回true就可以了
            }
            count += cur->left->val;
        }
        if (cur->right) {
            count -= cur->right->val;
            if (traversal(cur->right, count)) {
                return true;
            }
            count += cur->right->val;
        }

        return false;
    }
};
