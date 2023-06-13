#include <cstdio>
#include "Heap.h"

using namespace std;

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

    static void bubbleSort(int array[], int N) {
        printf("bubbleSort: \n");
        for (int i = 0; i < N - 1; ++i) {
            for (int j = 0; j < N - i - 1; ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        Print(array, N);
    }

    static void quickSort(int array[], int N) {
        printf("quickSort: \n");
        quickCore(array, 0, N - 1);
        Print(array, N);
    }

    static void quickCore(int array[], int left, int right) {
        if (left >= right) {
            return;
        }
        int keyi = quickPartition(array, left, right);
        quickPartition(array, left, keyi - 1);
        quickPartition(array, keyi + 1, right);
    }


    static int quickPartition(int array[], int left, int right) {
        int key = left;
        // 当left == right的时候我们退出循环
        while (left < right) {
            // 我们是左边的key，所以右边先走
            while (left < right && array[right] >= array[key]) {
                right--;
            }
            while (left < right && array[left] <= array[key]) {
                left++;
            }
            Swap(array, left, right);
        }
        return left;
    }

    static void Swap(int array[], int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    static void shellSort1(int array[], int N) {
        printf("shellSort1: \n");
        int gap = N;
        // gap > 1
        while (gap > 0) {
            gap = gap / 2;
            // 排序的起始位置
            for (int i = 0; i < gap; ++i) {
                for (int j = i; j < N - gap; ++j) {
                    int end = j;
                    int x = array[end + gap];
                    while (end >= 0) {
                        if (array[end] > x) {
                            array[end + gap] = array[end];
                            end = end - gap;
                        } else {
                            break;
                        }
                    }
                    array[end + gap] = x;
                }
            }
        }
        Print(array, N);
    }

    static void shellSort2(int array[], int N) {
        printf("shellSort2: \n");
        int gap = N;
        while (gap > 0) {
            gap /= 2;
            for (int i = 0; i < N - gap; ++i) {
                int end = i;
                int x = array[end + gap];
                while (end >= 0) {
                    if (array[end] > x) {
                        array[end + gap] = array[end];
                        end = end - gap;
                    } else {
                        break;
                    }
                }
                array[end + gap] = x;
            }
        }
        Print(array, N);
    }

    static void selectSort(int array[], int N) {
        printf("selectSort: \n");
        int mini = 0;
        for (int i = 0; i < N - 1; ++i) {
            mini = i;
            for (int j = i + 1; j < N; ++j) {
                if (array[mini] > array[j]) {
                    mini = j;
                }
            }
            swap(array[mini], array[i]);
        }
        Print(array, N);
    }

    // 向下调整, 大堆
    static void shiftDown(int array[], int parent, int len) {
        int child = 2 * parent + 1;
        while (child < len) {
            if (child + 1 < len && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int temp = array[child];
                array[child] = array[parent];
                array[parent] = temp;
                parent = child;
                child = 2 * parent + 1;
            } else {
                break;
            }
        }
    }

    static void createHeap(int array[], int N) {
        for (int parent = (N - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(array, parent, N);
        }
    }

    // 排升序，创建大根堆
    static void heapSort(int array[], int N) {
        printf("heapSort: \n");
        // 堆排序之后先建立堆
        createHeap(array, N);
        int end = N - 1;
        while (end >= 0) {
            int temp = array[0];
            array[0] = array[end];
            array[end] = temp;
            end--;
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
    Sort::shellSort1(arr, N);
    Sort::shellSort2(arr, N);
    Sort::selectSort(arr, N);
    Sort::bubbleSort(arr, N);
    Sort::quickSort(arr, N);
    return 0;
}
