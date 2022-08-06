   public static class Node {
        public int row;
        public int col;
        public int height;

        public Node(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.height - o2.height;
        }
    }

    public static int CatchWater2(int[][] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null || arr[0].length == 0) {
            return 0;
        }
        int N = arr.length;
        int M = arr[0].length;
        // isEnter[i][j] == true 之前进过
        // isEnter[i][j] == false 之前没有进过
        boolean[][] isEnter = new boolean[N][M];
        // 小根堆
        PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
        // 把四周的东西加入到小根堆里面去，因为四周是无法保存水的
        for (int row = 0; row < N; row++) {
            isEnter[row][0] = true;
            isEnter[row][M - 1] = true;
            heap.add(new Node(row, 0, arr[row][0]));
            heap.add(new Node(row, M - 1, arr[row][M - 1]));
        }
        for (int col = 0; col < M; col++) {
            isEnter[0][col] = true;
            isEnter[N - 1][col] = true;
            heap.add(new Node(0, col, arr[0][col]));
            heap.add(new Node(N - 1, col, arr[N - 1][col]));
        }

        int water = 0; // 每个位置的出水量，累加到water上面去
        int max = 0; // 在每个node弹出的时候，如果value更大，更新max，否则max的值维持不变
        while (!heap.isEmpty()) {
            Node cur = heap.poll();
            max = Math.max(max, cur.height);
            int r = cur.row;
            int c = cur.col;
            if (r > 0 && isEnter[r - 1][c]) {
                water += Math.max(0, max - arr[r - 1][c]);
                isEnter[r - 1][c] = true;
                heap.add(new Node(r - 1, c, arr[r - 1][c]));
            }
            if (r < N - 1 && isEnter[r + 1][c]) {
                water += Math.max(0, max - arr[r + 1][c]);
                isEnter[r + 1][c] = true;
                heap.add(new Node(r + 1, c, arr[r + 1][c]));
            }
            if (c > 0 && isEnter[r][c - 1]) {
                water += Math.max(0, max - arr[r][c - 1]);
                isEnter[r][c - 1] = true;
                heap.add(new Node(r, c - 1, arr[r][c - 1]));
            }
            if (c < M - 1 && isEnter[r][c + 1]) {
                water += Math.max(0, max - arr[r][c + 1]);
                isEnter[r][c + 1] = true;
                heap.add(new Node(r, c + 1, arr[r][c + 1]));
            }
        }
        return water;
    }
