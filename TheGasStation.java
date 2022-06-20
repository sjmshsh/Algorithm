class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //求得前缀和数组
        int N = gas.length;
        int[] arr = new int[N * 2];
        for (int i = 0; i < N; i++){
            arr[i] = gas[i] - cost[i];
            arr[i + N] = gas[i] - cost[i];
        }
        for(int i = 1; i < arr.length; i++){
            arr[i] += arr[i - 1];
        }
        boolean[] flg = new boolean[gas.length];
        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            while(!q.isEmpty() && arr[q.peekLast()] >= arr[i]){
                q.pollLast();
            }
            q.addLast(i);
        }
        for (int i = N, j = 0, offset = 0; i < arr.length; i++, offset = arr[j++]){
            if (arr[q.peekFirst()] - offset >= 0) {
                flg[j] = true;
            } else {
                flg[j] = false;
            }
            if(q.peekFirst() == j){
                q.pollFirst();
            }
            while (!q.isEmpty() && arr[q.peekLast()] >= arr[i]){
                q.pollLast();
            }
            q.addLast(i);
        }
        for (int i = 0; i < flg.length; i++){
            if (flg[i] == true) {
                return i;
            }
        }
        return -1;
    }
}
