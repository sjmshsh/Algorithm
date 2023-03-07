// https://leetcode.cn/problems/binary-tree-paths/

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
    public List<String> binaryTreePaths(TreeNode root) {
        // 存放结果
        List<String> result = new ArrayList<>();
        // 定义一个栈用来迭代
        Stack<Object> stack = new Stack<>();
        // 同时存入节点和路径
        stack.push(root);
        stack.push(root.val + "");
        while (!stack.isEmpty()) {
            // 路径是后插入进入的，所以先取出来的是路径
            String path = (String) stack.pop();
            TreeNode cur = (TreeNode) stack.pop();
            if (cur.left == null && cur.right == null) {
                result.add(path);
            }
            if (cur.left != null) {
                stack.push(cur.left);
                stack.push(path + "->" + cur.left.val);
            }
            if (cur.right != null) {
                stack.push(cur.right);
                stack.push(path + "->" + cur.right.val);
            }
        }
        return result;
    }
}




