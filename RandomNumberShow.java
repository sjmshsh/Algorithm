public class RandomFunc {
    //这个函数可以等概率的出现0 - 5
    public static int f1() {
        return (int) (Math.random() * 5);
    }

    //制作一个01转换器
    public static int f2() {
        int ans = f1();
        do {
            ans = f1();
        } while (ans == 3);
        return ans < 3 ? 1 : 0;
    }

    //利用位操作得到0 - 63的范围
    public static int f3() {
        return (f2() << 6) + (f2() << 5) + (f2() << 4) + (f2() << 3) + (f2() << 2)
                + (f2() << 1) + f2();
    }

    //得到 0 - 39的范围
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans <= 39);
        return ans;
    }

    public static int g() {
        return f4() + 17;
    }

    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

    public static void main(String[] args) {

    }
}
