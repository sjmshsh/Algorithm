package Algorithm;

import java.util.*;

/**
 * @Author 写你的名字
 * @Date 2022/6/11 7:28 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
public class binary_tree {


    static class TreeNode {
        private TreeNode right = null;
        private TreeNode left = null;
        private char val;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    static public TreeNode TreeCreate () {
        TreeNode nodeA = new TreeNode('A');
        TreeNode nodeB = new TreeNode('B');
        TreeNode nodeC = new TreeNode('C');
        TreeNode nodeD = new TreeNode('D');
        TreeNode nodeE = new TreeNode('E');
        TreeNode nodeF = new TreeNode('F');
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        return nodeA;
    }

    static void LayerOrderTraversal (TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }

    static List<TreeNode> preorderTraversal (TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root);
        List<TreeNode> left = preorderTraversal(root.left);
        list.addAll(left);
        List<TreeNode> right = preorderTraversal(root.right);
        list.addAll(right);
        return list;
    }

    static int size (TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

    //获取叶子结点的个数
    static int getLeafNodeCount (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        return getLeafNodeCount(root.left) + getLeafNodeCount(root.right);
    }

    //获取第K层结点个数
    static int getLevelNodeCount (TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        return getLevelNodeCount(root.left, k - 1) +
                getLevelNodeCount(root.right, k - 1);
    }

    static int getHeight (TreeNode root) {
        //左子树的高度和右子树的高度的最大值 + 1
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    //检测value值是否存在
    static TreeNode find (TreeNode root, char val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        TreeNode cur = find(root.left, val);
        if (cur != null) {
            return cur;
        }
        cur = find(root.right, val);
        if (cur != null) {
            return cur;
        }
        return null;
    }

    //判断一棵树，是不是完全二叉树
    static boolean isCompleteTree (TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                return false;
            }
        }
        return true;
    }

    //判断一棵树是否是平衡二叉树
    static boolean isBalancedTree (TreeNode root) {
        if (root == null) {
            return true;
        }
        return height(root) > 0;
    }

    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }

    //给定一个前序遍历，创建出一颗二叉树
    public static int i = 0;
    public static TreeNode preorderTreeCreated (String str) {
        TreeNode root = null;
        if (str.charAt(i) != '#') {
            root = new TreeNode(str.charAt(i));
            root.left = preorderTreeCreated(str);
            root.right = preorderTreeCreated(str);
        }
        i++;
        return root;
    }

    //求二叉树的最近的公共祖先
    static TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    static boolean getPath (TreeNode root, TreeNode target, Stack<TreeNode> stack) {
        if (root == null || target == null) {
            return false;
        }
        stack.push(root);
        if (root.val == target.val) {
            return true;
        }
        if (getPath(root.left, target, stack) == true) {
            return true;
        }
        if (getPath(root.right, target, stack) == true) {
            return true;
        }
        stack.pop();
        return false;
    }

    static TreeNode _lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (getPath(root, p, s1) == false || getPath(root, q, s2) == false) {
            return null;
        }
        Stack<TreeNode> more = s1;
        Stack<TreeNode> less = s2;
        int moreSize = more.size();
        int lessSize = less.size();
        if (moreSize < lessSize) {
            more = s2;
            less = s1;
        }
        int sub = more.size() - less.size();
        while (sub != 0) {
            more.pop();
            sub--;
        }
        while (!more.isEmpty() && !less.isEmpty()) {
            if (more.peek().val == less.peek().val) {
                break;
            } else {
                more.pop();
                less.pop();
            }
        }
        return more.peek();
    }

    //二叉树转向双向链表
    public static TreeNode Convert (TreeNode root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        TreeNode head = root;
        while (head.left != null) {
            head = head.left;
        }
        return head;
    }

    private static TreeNode pre = null;
    private static void inorder(TreeNode pCur) {
        if (pCur == null) {
            return;
        }
        inorder(pCur.left);
        pCur.left = pre;
        if (pre != null) {
            pre.right = pCur;
        }
        pre = pCur;
        inorder(pCur.right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeCreate();
        LayerOrderTraversal(root);
        System.out.println();
        List<TreeNode> list = preorderTraversal(root);
        for (TreeNode cur : list) {
            System.out.print(cur.val + " ");
        }
        System.out.println();
        System.out.println(size(root));
        System.out.println(getLeafNodeCount(root));
        System.out.println(getLevelNodeCount(root, 2));
        System.out.println(getHeight(root));
        TreeNode findNode = find(root, 'D');
        try {
            System.out.println(findNode.val);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        System.out.println(isCompleteTree(root));
        System.out.println(isBalancedTree(root));
    }
}
