// A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
// A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
// 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { 
            int A_B = in.nextInt();
            int B_C = in.nextInt();
            int AB = in.nextInt();
            int BC = in.nextInt();
            
            int A = (A_B + AB) / 2;
            int C = (BC - B_C) / 2;
            int B1 = (B_C + BC) / 2;
            int B2 = (AB - A_B) / 2;
            if (B1 != B2) {
                System.out.println("No");
            } else {
                System.out.println(A + " " + B1 + " " + C);
            }
        }
    }
}
