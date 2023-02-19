// http://oj.daimayuan.top/course/5/problem/161

public class _01Bag {
    private static int n;
    private static int m;
    // 物品的体积
    private static int[] v = new int[1010];
    // 物品的收益
    private static int[] w = new int[1010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        // dp[i][j]的含义是
        // 当我取前i个物品，且袋子此时的总重量为j的时候，最大的收益是多少
        int[][] dp = new int[n + 1][m + 1];
        // 下标为0的时候表示没有物品可以取，因此重量也为0，收益也为0，不用管就行了
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 第一种可能性，我不要这个位置的背包
                dp[i][j] = dp[i - 1][j];
                // 第二种可能性
                if (j - v[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
