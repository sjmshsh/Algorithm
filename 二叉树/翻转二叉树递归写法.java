// 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
// https://leetcode.cn/problems/invert-binary-tree/

 // 解题思路很简单，就是把每一个子二叉树的左右节点都进行翻转就行了
class Solution {
    public TreeNode invertTree(TreeNode root) {
        invertTreeCore(root);
        return root;
    }

    public void invertTreeCore(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeCore(root.left);
        invertTreeCore(root.right);
    }
}

