class Solution {

    public List<Integer> result = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        postorderTraversalCore(root);
        return result;
    }

    public void postorderTraversalCore(TreeNode root) {
        if (root == null) {
            return;
        }
        postorderTraversalCore(root.left);
        postorderTraversalCore(root.right);
        result.add(root.val);
    }
}
