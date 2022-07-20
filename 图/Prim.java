public Integer Prim(Graph<Integer> minTree, V src) { // 给出一个起点
    int srci = GetVertexIndex(src);
    int n = vertexs.size();
    // X表示已经选择过的边, Y表示还没用选择过的边
    boolean[] X = new boolean[n];
    boolean[] Y = new boolean[n];
    for (int i = 0; i < n; i++) {
        Y[i] = true;
    }
    X[srci] = true;
    Y[srci] = false;
    PriorityQueue<Edge> minq = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
        if (matrix[srci][i] != Integer.MAX_VALUE) {
            minq.add(new Edge(srci, i, matrix[srci][i]));
        }
    }
    int size = 0;
    int total = 0;
    while (!minq.isEmpty()) {
        Edge min = minq.poll();
        // 最小边的目标点也在X集合，则构成环
        if (X[min.dsti] == true) {
            System.out.println("构成环了，再选!");
        } else {
            minTree.AddEdge(min.srci, min.dsti, min.w);
            X[min.dsti] = true;
            Y[min.dsti] = false;
            ++size;
            total += min.w;
            if (size == n - 1) {
                break;
            }
            for (int i = 0; i < n; i++) {
                if (matrix[min.dsti][i] != Integer.MAX_VALUE && Y[i] == true) {
                    minq.add(new Edge(min.dsti, i, matrix[min.dsti][i]));
                }
            }
        }
    }
    if (size == n - 1) {
        return total;
    } else {
        return -1;
    }
}
