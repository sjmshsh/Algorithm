public class CatchWater {
    public static int CatchWater(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int L = 1;
        int R = N - 2;
        int maxLeft = arr[0];
        int maxRight = arr[N - 1];
        int water = 0;
        while (L <= R) {
            if (maxLeft <= maxRight) {
                water += Math.max(0, maxLeft - arr[L]);
                maxLeft = Math.max(maxLeft, arr[L++]);
            } else {
                water += Math.max(0, maxRight - arr[R]);
                maxRight = Math.max(maxRight, arr[R++]);
            }
        }
        return water;
    }
}
