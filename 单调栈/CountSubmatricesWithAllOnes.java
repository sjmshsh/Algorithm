public class CountSubmatricesWithAllOnes {
    // 计算矩形数量
    public static int num(int n) {
        return ((n * (1 + n)) >> 1);
    }

    // 抽象成直方图
    public static int numSubmat(int[][] mat) {
        int nums = 0;
        int[] height = new int[mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
            }
            nums += countFromBottom(height);
        }
        return nums;
    }

    private static int countFromBottom(int[] height) {
        int nums = 0;
        int[] stack = new int[height.length];
        int si = -1;
        for (int i = 0; i < height.length; i++) {
            while (si != -1 && height[i] <= height[stack[si]]) {
                int cur = stack[si--];
                // 如果相等的话就不算了，但是单调栈的时候必须要加上‘=’，不然的话就要用链表形式了
                if (height[cur] > height[i]) {
                    int left = si == -1 ? -1 : stack[si];
                    int n = i - left - 1;
                    int down = Math.max(left == -1 ? 0 : height[left], height[i]);
                    nums += (height[cur] - down) * num(n);
                }
            }
            stack[++si] = i;
        }
        while (si != -1) {
            int cur = stack[si--];
            int left = si == -1 ? -1 : stack[si];
            int n = height.length - left - 1;
            int down = left == -1 ? 0 : height[left];
            nums += (height[cur] - down) * num(n);
        }
        return nums;
    }
}
