// 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

// https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true; // 如果是空节点的话，那么就是一颗平衡二叉树
        }
        return height(root) > 0;
    }

    // 求树的高度
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 求出左子树的高度
        int leftHeight = height(root.left);
        // 求出右子树的高度
        int rightHeight = height(root.right);
        if (leftHeight >= 0 && rightHeight >= 0 && Math.abs(leftHeight - rightHeight) <= 1) {
            return Math.max(leftHeight, rightHeight) + 1;
        } else {
            return -1;
        }
    }
}



