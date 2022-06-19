public class 所有子数组最小值中的最大值 {
    public static void main(String[] args) {
        int[] arr = {1, 4, -3, 4, -5};
        int N = arr.length;
        int num = 3; //子数组里面的最大值 - 最小值 <= num
        int count = 0; //用来记录有多少个子数组
        int R = 0; //定义右边界
        Deque<Integer> maxdeque = new LinkedList<>();
        Deque<Integer> mindeque = new LinkedList<>();
        for (int L = 0; L < N; L++) {
            while (R < N) {
                //维护大的双端队列
                while (!maxdeque.isEmpty() && arr[maxdeque.peekLast()] <= arr[R]) {
                    maxdeque.removeLast();
                }
                maxdeque.add(R);
                //维护小的双端队列
                while (!mindeque.isEmpty() && arr[mindeque.peekLast()] >= arr[R]) {
                    mindeque.removeLast();
                }
                mindeque.add(R);
                if ((arr[maxdeque.peekFirst()] - arr[mindeque.peekFirst()]) > num) {
                    break;
                } else {
                    R++;
                }
            }
            count += R - L;
            if (maxdeque.peekFirst() == L) {
                maxdeque.removeFirst();
            }
            if (mindeque.peekFirst() == L) {
                mindeque.removeFirst();
            }
        }
        System.out.println(count);
    }
}
