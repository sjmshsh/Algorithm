public class CordCoverMaxPoint {
    public static int maxPoint1(int[] arr, int L) {
        int res = 1; // 这里最少就是1，因为我没有必要不覆盖每一个点
        for (int i = 0; i < arr.length; i++) {
            int nearest = nearestIndex(arr, i, arr[i] - L);
            res = Math.max(res, i - res + 1);
        }
        return res;
    }

    private static int nearestIndex(int[] arr, int R, int value) {
        int L = 0;
        int index = R;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= value) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }

    public static int maxPoint2(int[] arr, int L) {
        int left = 0;
        int right = 0;
        int N = arr.length;
        int max = 0;
        while (left < N) {
            while (right < N && arr[right] - arr[left] <= L) {
                right++;
            }
            max = Math.max(max, right - (left++));
        }
        return max;
    }
}
