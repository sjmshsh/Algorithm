package Algorithm;

/**
 * @Author 写你的名字
 * @Date 2022/6/11 17:56 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
public class KMP {
    public static int getIndexOf (String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < 1 || s2.length() > s1.length()) {
            return -1;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        //x和y是比对的位置
        int x = 0;
        int y = 0;
        int[] next = getNextArray(str2);

        // o(N)
        while (x < str1.length && y < str2.length) {
            if (str1[x] == str2[y]) {
                x++;
                y++;
            } else if (next[y] == -1) { // y == 0
                x++;
            } else {
                y = next[y];
            }
        }
        return y == str2.length ? x - y : -1;
    }

    // 使用动态规划来求
    private static int[] getNextArray(char[] str2) {
        if (str2.length == 1) {
            return new int[] {-1};
        }
        int[] next = new int[str2.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < next.length) {
            if (str2[i - 1] == str2[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "f";
        int index = getIndexOf(s1, s2);
        System.out.println(index);
    }
}
