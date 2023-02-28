// 给定一个二叉树，找出其最大深度。

// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

// 说明: 叶子节点是指没有子节点的节点。


 // 使用后序遍历求最大深度
class Solution {
    public int maxDepth(TreeNode root) {
        return maxDepthCore(root);
    }

    public int maxDepthCore(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftdepth = maxDepthCore(root.left);
        int rightdepth = maxDepthCore(root.right);
        int depth = Math.max(leftdepth, rightdepth) + 1;
        return depth;
    }
}


