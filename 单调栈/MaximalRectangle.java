public class MaximalRectangle {
     public static int maximalRectangle(char[][] map) {
         int maxArea = 0;
         int[] height = new int[map[0].length];
         for (int i = 0; i < map.length; i++) {
             for (int j = 0; j < map[0].length; j++) {
                 height[j] = map[i][j] == '0' ? 0 : height[j] + 1;
             }
             maxArea = Math.max(maxArea, maxRecFromBottom(height));
         }
         return maxArea;
     }

    private static int maxRecFromBottom(int[] height) {
         int maxArea = 0;
         Stack<Integer> stack = new Stack<>();
         for (int i = 0; i < height.length; i++) {
             while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                 int j = stack.pop();
                 int k = stack.isEmpty() ? -1 : stack.peek();
                 int curArea = (i - k - 1) * height[j];
                 maxArea = Math.max(maxArea, curArea);
             }
             stack.push(i);
         }
         while (!stack.isEmpty()) {
             int j = stack.pop();
             int k = stack.isEmpty() ? -1 : stack.peek();
             int curArea = (height.length - k - 1) * height[j];
             maxArea = Math.max(maxArea, curArea);
         }
         return maxArea;
    }
}
