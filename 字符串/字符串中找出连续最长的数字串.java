//读入一个字符串str，输出字符串str中的连续最长的数字串
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { 
            String a = in.nextLine();
            char[] arr = a.toCharArray();
            String res = "";
            String temp = "";
            int i = 0;
            for (; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    temp += arr[i];
                } else {
                    if (res.length() < temp.length()) {
                        res = temp;
                    } else {
                        temp = "";
                    }
                }
            }
            // 处理最后一个字符串是数字的情况，如果是数字则循环进不来
            if (i == arr.length && temp.length() > res.length()) {
                res = temp;
            }
            System.out.println(res);
        }
    }
}
