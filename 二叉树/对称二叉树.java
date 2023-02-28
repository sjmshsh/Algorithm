// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
// https://leetcode.cn/problems/symmetric-tree/

 // 思路很简单，检查每一棵子树是否对称即可
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricCore(root.left, root.right);
    }

    public boolean isSymmetricCore(TreeNode left, TreeNode right) {
        // 左节点和右节点都是空，那么返回true
        if (left == null && right == null) {
            return true;
        }
        // 左节点为空，右节点不为空或者是左节点不为空，右节点为空，不对称，返回false
        if (left == null || right == null) {
            return false;
        }

        // 如果都不为空，那么就比较它们的值
        if (left.val != right.val) {
            return false;
        }

        return isSymmetricCore(left.left, right.right) && isSymmetricCore(left.right, right.left);
    }
}

