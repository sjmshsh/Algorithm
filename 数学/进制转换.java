// 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数

// 思路，这道题的代码非常优雅，要多学习
import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { 
            int m = in.nextInt();
            int n = in.nextInt();
            if (m == 0) {
                System.out.println("0");
                continue;
            }
            // 定义一张哈希表
            String table = "0123456789ABCDEF";
            // 定义存放结果的字符串
            String res = "";

            // 首先判断正负
            boolean flg = true;
            if (m < 0) {
                m = 0 - m;
                flg = false; // 代表是负数
            }
            while (m != 0) {
                res += table.charAt(m % n);
                m = m / n;
            }
            if (flg == false) {
                res += "-";
            }
            StringBuffer sb = new StringBuffer(res);
            System.out.println(sb.reverse());
        }
    }
}
