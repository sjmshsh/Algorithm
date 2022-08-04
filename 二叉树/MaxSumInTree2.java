    public static int max = Integer.MIN_VALUE;

    // 从任意节点出发，到叶节点为止, 这个函数返回的结果是以head为头节点的树的最大路径和
    public static int bigShuai(Node head) {
        if (head.left == null && head.right == null) {
            max = Math.max(max, head.value);
            return head.value;
        }
        int nextMax = 0;
        if (head.left != null) {
            nextMax = bigShuai(head.left);
        }
        if (head.right != null) {
            nextMax = Math.max(nextMax, bigShuai(head.right));
        }
        int ans = head.value + nextMax;
        max = Math.max(max, ans);
        return ans;
    }
