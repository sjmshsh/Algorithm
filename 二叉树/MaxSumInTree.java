public class MaxSumInTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int val) {
            value = val;
        }
    }

    public static int maxSum = Integer.MIN_VALUE;

    public static int maxPath (Node head) {
        p(head, 0);
        return maxSum;
    }

    // 之前路径的和为pre
    private static void p(Node head, int pre) {
        if (head.left == null && head.right == null) {
            maxSum = Math.max(maxSum, pre + head.value);
        }
        if (head.left != null) {
            p(head.left, pre + head.value);
        }
        if (head.right != null) {
            p(head.right, pre + head.value);
        }
    }

    public static int maxDis(Node head) {
        if (head == null) {
            return 0;
        }
        return process2(head);
    }

    // x为头的整棵树上，最大路径和是多少，返回
    // 路径要求，一定从x出发，到叶节点，算作一个路径
    private static int process2(Node x) {
        if (x.left == null && x.right == null) {
            return x.value;
        }
        int next = Integer.MIN_VALUE;
        if (x.left != null) {
            next = process2(x.left);
        }
        if (x.right != null) {
            next = Math.max(next, process2(x.right));
        }
        return x.value + next;
    }
    
    
    
    public static int maxSum2(Node head) {
    	if (head == null) {
    	    return 0;
        }
    	return f(head).allTreeMaxSum;
    }

    public static int maxSum3(Node head) {
        if (head == null) {
            return 0;
        }
        return f2(head).allTreeMaxSum;
    }
    
    
    public static class Info {
    	public int allTreeMaxSum; // 整树最和
    	public int fromHeadMaxSum; // 从头最和, 从头节点出发的最大和
    	public Info (int all, int from) {
    		all = allTreeMaxSum;
    		from = fromHeadMaxSum;
    	}
    }
    
    // 1) X无关的时候，  1. 左树上的整体最大路径和  2. 右树上的整体最大路径和
    // 2) X有关的时候    3. X自己    4. X往右走   5.X往左走
    public static Info f(Node x) {
    	if (x == null) {
    		return null;
    	}
    	Info leftInfo = f(x.left);
    	Info rightInfo = f(x.right);
    	int p1 = Integer.MIN_VALUE;
    	if (leftInfo != null) {
    		p1 = leftInfo.allTreeMaxSum;
    	}
    	int p2 = Integer.MIN_VALUE;
    	if (rightInfo != null) {
    		p2 = rightInfo.allTreeMaxSum;
    	}
    	int p3 = x.value;
    	int p4 = Integer.MIN_VALUE;
    	if (leftInfo != null) {
    		p4 = x.value + leftInfo.fromHeadMaxSum;
    	}
    	int p5 = Integer.MIN_VALUE;
    	if (rightInfo != null) {
    		p5 = x.value + rightInfo.fromHeadMaxSum;
    	}
    	int allTreeMaxSum = Math.max(Math.max(Math.max(Math.max(p4, p5), p3), p2), p1);
    	int fromHeadMaxSum = Math.max(Math.max(p3, p4), p5);
    	return new Info(allTreeMaxSum, fromHeadMaxSum);
    }

    // 1) X无关的时候，  1. 左树上的整体最大路径和  2. 右树上的整体最大路径和
    // 2) X有关的时候    3. X自己    4. X往右走   5.X往左走   6.既往左又往右
    public static Info f2(Node x) {
        if (x == null) {
            return null;
        }
        Info leftInfo = f2(x.left);
        Info rightInfo = f2(x.right);
        int p1 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p1 = leftInfo.allTreeMaxSum;
        }
        int p2 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p2 = rightInfo.allTreeMaxSum;
        }
        int p3 = x.value;
        int p4 = Integer.MIN_VALUE;
        if (leftInfo != null) {
            p4 = x.value + leftInfo.fromHeadMaxSum;
        }
        int p5 = Integer.MIN_VALUE;
        if (rightInfo != null) {
            p5 = x.value + rightInfo.fromHeadMaxSum;
        }
        int p6 = Integer.MIN_VALUE;
        if (leftInfo != null && rightInfo != null) {
            p6 = x.value + leftInfo.fromHeadMaxSum + rightInfo.fromHeadMaxSum;
        }
        // 这里我们要加上p6的大小比较
        int allTreeMaxSum = Math.max(Math.max(Math.max(Math.max(p4, Math.max(p5, p6)), p3), p2), p1);
        // 但是这里我们不能加上p6的比较，因为
        int fromHeadMaxSum = Math.max(Math.max(p3, p4), p5);
        return new Info(allTreeMaxSum, fromHeadMaxSum);
    }
}


