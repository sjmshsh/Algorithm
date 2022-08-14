class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int N = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && i < N && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == N;
    }
}
