class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N * 2; i++) {
            // 这里不可以加上等于号，原因是我的题目要求是一定是大于，不可能是等于
            while (!stack.isEmpty() && nums[i % N] > nums[stack.peek() % N]) {
                res[stack.pop() % N] = nums[i % N];
            }
            stack.push(i % N);
        }
        return res;
    }
}
