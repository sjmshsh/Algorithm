package Heap;

import java.util.Arrays;
/**
 * @Author 写你的名字
 * @Date 2022/7/1 20:05 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

/*
* 大根堆!!!!
* */
public class heap {
    static void headSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int N = arr.length;
        // 建堆
        // O(logN*N)
//        for (int i = 0; i < N; i++) {
//            heapInsert(arr, i);
//        }
        // O(N)
        for (int i = (N - 1 - 1) / 2; i >= 0; i--) {
            heapify(arr, i, N);
        }
        //堆排序
        int heapSize = arr.length;
        Swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, --heapSize);
            Swap(arr, 0, heapSize);
        }
    }

    static void heapify(int[] arr, int index, int heapSize) {
        int child = index * 2 + 1;
        while (child < heapSize) {
            if (child + 1 < heapSize && arr[child] < arr[child + 1]) {
                child++;
            }
            if (arr[child] > arr[index]) {
                Swap(arr, index, child);
                index = child;
                child = index * 2 + 1;
            } else {
                break;
            }
        }
    }

    static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            Swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    static void Swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        heap.headSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
