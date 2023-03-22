// https://leetcode.cn/problems/house-robber-iii/

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
    public int rob(TreeNode root) {
        // 定义dp的下标0代表不偷，1代表偷.值表示当前最大的偷窃金额
        int[] res = robCore(root);
        return Math.max(res[0], res[1]);
    }

    public int[] robCore(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = robCore(root.left);
        int[] right = robCore(root.right);

        // 偷root节点，那么左孩子和右孩子就不能偷了
        int val1 = root.val + left[0] + right[0];
        // 不偷
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{val2, val1};
    }
}








