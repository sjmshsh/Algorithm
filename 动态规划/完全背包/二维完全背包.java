// http://oj.daimayuan.top/course/5/problem/162

public class _01BagOne {

    //n表示有n个物品可以取，m表示有物体的总体积是m
    private static int n;
    private static int m;
    // 体积
    private static int[] v = new int[1010];
    // 收益
    private static int[] w = new int[1010];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();
        }
        int[][] dp = new int[1010][1010];
        for (int i = 1; i <= n; i++) { // 枚举物品
            for (int j = 0; j <= m; j++) { // 枚举重量
                // 这个物品你可以不选择
                dp[i][j] = dp[i - 1][j];
                // 这个物品你也可以选择
                if (j - v[i] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - v[i]] + w[i]);
                }
            }
        }
        System.out.println(dp[n][m]);
    }
}
