#include <cstdio>
class Sort {
public:
    static void insertSort(int array[], int N) {
        for (int i = 0; i < N - 1; ++i) {
            int end = i;
            int x = array[end + 1];
            while (end >= 0) {
                if (array[end] > x) {
                    array[end + 1] = array[end];
                    end--;
                } else {
                    break;
                }
            }
            array[end + 1] = x;
        }

        for (int i = 0; i < N; i++) {
            printf("%d ", array[i]);
        }
        printf("\n");
    }
};

int main() {
    int arr[] = {5,6,9,8,7,3,5,4};
    Sort::insertSort(arr, sizeof(arr) / sizeof(arr[0]));
    return 0;
}
