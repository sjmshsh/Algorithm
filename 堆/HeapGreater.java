package Heap;

import java.util.*;

/**
 * @Author 写你的名字
 * @Date 2022/7/14 14:46 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

/*
 * T一定要是非基础类型，有基础类型需求包一层
 */

public class HeapGreater<T> {

    private ArrayList<T> heap;
    private HashMap<T, Integer> indexMap;
    private int heapSize;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<? super T> c) {
        heap = new ArrayList<>();
        indexMap = new HashMap<>();
        heapSize = 0;
        comp = c;
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize;
    }

    public boolean contains(T obj) {
        return indexMap.containsKey(obj);
    }

    public T peek() {
        return heap.get(0);
    }

    public void push(T obj) {
        heap.add(obj);
        indexMap.put(obj, heapSize);
        heapInsert(heapSize++);
    }

    public T pop() {
        T ans = heap.get(0);
        swap(0, heapSize - 1);
        indexMap.remove(ans);
        heap.remove(--heapSize);
        heapify(0);
        return ans;
    }

    public void remove(T obj) {
        // 把数组最后一个数据的值拿出来
        T replace = heap.get(heapSize - 1);
        // 把要删除的值的数据下标拿出来
        int index = indexMap.get(obj);
        // 在hashMap里面删除obj对象
        indexMap.remove(obj);
        // 把数组的最后一个数据删除，为什么是最后一个不是第一个，因为最后一个效率是最高的
        heap.remove(--heapSize);
        // 如果obj和replace刚好相等的话就代表已经删除了，就不需要进行后序操作了
        if (obj != replace) {
            // 把index换成replace，这样就等效于已经删除成功了
            heap.set(index, replace);
            indexMap.put(replace, index);
            // 把堆进行调整
            resign(replace);
        }
    }

    public void resign(T obj) {
        heapInsert(indexMap.get(obj));
        heapify(indexMap.get(obj));
    }

    // 请返回堆上的所有元素
    public List<T> getAllElements() {
        List<T> ans = new ArrayList<>();
        for (T c : heap) {
            ans.add(c);
        }
        return ans;
    }

    private void heapInsert(int index) {
        while (comp.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            swap(index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int index) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int best = left + 1 < heapSize && comp.compare(heap.get(left + 1), heap.get(left)) < 0 ? (left + 1) : left;
            best = comp.compare(heap.get(best), heap.get(index)) < 0 ? best : index;
            if (best == index) {
                break;
            }
            swap(best, index);
            index = best;
            left = index * 2 + 1;
        }
    }

    private void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);
        heap.set(i, o2);
        heap.set(j, o1);
        indexMap.put(o2, i);
        indexMap.put(o1, j);
    }
}
