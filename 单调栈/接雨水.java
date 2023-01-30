//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
class Solution {
    public int trap(int[] height) {
        int N = height.length;
        Stack<Integer> stack = new Stack<>();
        int water = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int k = stack.pop(); // 当前元素
                // 阵列要注意以下，这里必须是continue，如果栈为空的话，水是装不下的
                if (stack.isEmpty()) {
                    continue;
                }
                // 左边的元素
                int left = stack.peek();
                // 算长度
                int w = i - left + 1 - 2;
                // 算高度
                int h = Math.min(height[i], height[left]) - height[k];
                water += w * h;
            }
            stack.push(i);
        }
        return water;
    }
}
