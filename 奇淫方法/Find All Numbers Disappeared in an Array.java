class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int x = (num - 1) % N;
            nums[x] += N;
        }
        for (int i = 0; i < N; i++) {
            if (nums[i] <= N) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
