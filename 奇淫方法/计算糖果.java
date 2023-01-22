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
