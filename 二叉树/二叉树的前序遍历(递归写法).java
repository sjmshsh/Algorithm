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

    public List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        preorderTraversalCore(root);
        return list;
    }

    public void preorderTraversalCore(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversalCore(root.left);
        preorderTraversalCore(root.right);
    }
}
