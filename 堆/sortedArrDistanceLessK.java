package Heap;

import java.util.PriorityQueue;

/**
 * @Author 写你的名字
 * @Date 2022/7/2 21:39 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
public class sortedArrDistanceLessK {
    static void SortedArrDistanceLessK(int[] arr, int k) {
        // 默认是小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (; index < Math.min(arr.length - 1, k - 1); index++) {
            heap.add(arr[index]);
        }
        int i = 0;
        for (; index < arr.length; index++, i++) {
            heap.add(arr[index]);
            arr[i] = heap.poll();
        }
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
