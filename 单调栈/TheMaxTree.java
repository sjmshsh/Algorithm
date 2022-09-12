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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int N = nums.length;
        TreeNode[] stack = new TreeNode[N];
        int top = 0;
        for (int i = 0; i < N; i++) {
            TreeNode node = new TreeNode(nums[i]);
            while (top != 0 && stack[top - 1].val <= nums[i]) {
                node.left = stack[--top];
            }
            if (top != 0){
                stack[top - 1].right = node;
            }
            stack[top++] = node;
        }
        return stack[0];
    }
}
