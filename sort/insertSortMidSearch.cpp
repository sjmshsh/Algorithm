#include <cstdio>

class Sort {
public:
    static void insertSort(int array[], int N) {
        printf("insertSort: \n");
        for (int i = 0; i < N - 1; ++i) {
            int end = i;
            int x = array[end + 1];
            while (end >= 0) {
                if (array[end] >= x) {
                    array[end + 1] = array[end];
                    end--;
                } else {
                    break;
                }
            }
            array[end + 1] = x;
        }
        Print(array, N);
    }

    static void insertSortMidSearch(int array[], int N) {
        printf("insertSortMidSearch: \n");
        for (int i = 1; i < N; ++i) {
            int v = array[i]; // 我们需要查找大于等于v的最左边界
            int left = 0;
            // 我们可以保证的是[left, right]之间是有序的
            int right = i - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (array[mid] >= v) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // 程序到这里的时候就代表left已经是最左边界了
            for (int j = i; j > left; j--) {
                array[j] = array[j - 1];
            }
            array[left] = v;
        }
        Print(array, N);
    }

private:
    static void Print(int array[], int N) {
        for (int i = 0; i < N; i++) {
            printf("%d ", array[i]);
        }
        printf("\n");
    }
};

int main() {
    int arr[] = {5, 6, 9, 8, 7, 3, 5, 4};
    int N = sizeof(arr) / sizeof(arr[0]);
    Sort::insertSort(arr, N);
    Sort::insertSortMidSearch(arr, N);
    return 0;
}
