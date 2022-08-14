class Solution {

    public int midSearch(int[] arr, int target) {
        int L = 0;
        int R = arr.length - 1;
        // 采用[L, R]
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] <= target) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return R;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        // 先用二分查找寻找是哪一列
        int N = matrix.length;
        int M = matrix[0].length;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = matrix[i][0];
        }
        int index = midSearch(arr, target);
        if (index == -1 || index == N) {
            return false;
        }
        int ans = midSearch(matrix[index], target);
        if (matrix[index][ans] == target) {
            return true;
        } else {
            return false;
        }
    }
}
