// https://leetcode.cn/problems/sum-of-left-leaves/

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
 // 迭代写法
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null && cur.left.left == null && cur.left.right == null) {
                result += cur.left.val;
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return result;
    }
}
