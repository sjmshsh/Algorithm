// 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

// https://leetcode.cn/problems/count-complete-tree-nodes/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        return countNodesCore(root);
    }

    public int countNodesCore(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countNodesCore(root.left);
        int right = countNodesCore(root.right);
        int number = left + right + 1;
        return number;
    }
}
