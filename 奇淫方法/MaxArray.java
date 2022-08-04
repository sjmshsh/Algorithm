public class ArrayMax {
    public static int MaxArray(int[] arr) {
        int maxValue = 0;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Math.max(maxValue, arr[i]);
        }
        int ans = maxValue - Math.min(arr[0], arr[arr.length - 1]);
        return ans;
    }
}
