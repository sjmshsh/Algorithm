public class ColorLeftRight {
    public static int minPaint(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] right = new int[N];
        right[N - 1] = str[N - 1] == 'R' ? 1 : 0;
        for (int i = N - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (str[i] == 'R' ? 1 : 0);
        }
        int ans = right[0];
        int left = 0;
        for (int i = 0; i < N - 1; i++) {
            left += str[i] == 'G' ? 1 : 0;
            ans = Math.min(ans, left + right[i + 1]);
        }
        // 0...N-1 左 右 无
        ans = Math.min(ans, left + (str[N - 1] == 'G' ? 1 : 0));
        return ans;
    }
}
