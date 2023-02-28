// 给你一个二叉树的根节点 root ， 检查它是否轴对称。
// https://leetcode.cn/problems/symmetric-tree/

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 成对的加入，先加入左，再加入右。因此取出的时候也是先加入左，再加入右
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 左节点和右节点都是空
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null || right.val != left.val) {
                return false;
            }
            // 成对加入
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}
