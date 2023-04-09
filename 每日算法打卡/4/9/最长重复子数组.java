class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int N = nums1.length;
        int M = nums2.length;
        int res = 0;
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (res < dp[i][j]) {
                    res = dp[i][j];
                }
            }
        } 
        return res;
    }
}
