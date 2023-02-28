// 给定一个二叉树，找出其最小深度。

// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

// 说明：叶子节点是指没有子节点的节点。

// https://leetcode.cn/problems/minimum-depth-of-binary-tree/

class Solution {
    public int minDepth(TreeNode root) {
        return minDepthCore(root);
    }

    public int minDepthCore(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = minDepthCore(root.left);
        int rightdepth = minDepthCore(root.right);
        // 如果左子树为空，右子树不为空
        if (root.left == null && root.right != null) {
            return 1 + rightdepth;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftdepth;
        }
        int depth = Math.min(leftdepth, rightdepth) + 1;
        return depth;
    }
}


