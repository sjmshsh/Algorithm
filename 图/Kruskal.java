    // 把边这个结构表示出来，不然的话是不方便使用优先级队列的
    class Edge implements Comparable<Edge> {
        public int srci;
        public int dsti;
        public Integer w; //边权

        public Edge(int srci, int dsti, Integer w) {
            this.srci = srci;
            this.dsti = dsti;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    // 找到本个图的最小生成树的数值并且返回
    public Integer Kruskal() {
        int n = vertexs.size();
        PriorityQueue<Edge> minque = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 最小生成树都是无向图
                if (i < j && matrix[i][j] != Integer.MAX_VALUE) {
                    minque.add(new Edge(i, j, matrix[i][j]));
                }
            }
        }
        // 选出 n - 1 条边
        int size = 0;
        int total = 0;
        UnionF1 unionF1 = new UnionF1(n);
        while (!minque.isEmpty()) {
            Edge min = minque.poll();
            if (!unionF1.isSameFather(min.srci, min.dsti)) {
                unionF1.Union(min.srci, min.dsti);
                size++;
                total += min.w;
            } else {
                System.out.println("构成环");
            }
        }
        if (size == n - 1) {
            return total;
        } else {
            return -1;
        }
    }

public class UnionF1 {
    private int[] parent;
    private int[] help;
    private int[] size;
    private int sets = 0; //这个变量用来记录这个并查集里面有多少个集合

    public UnionF1(int n) {
        parent = new int[n];
        help = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int Counts() {
        return sets;
    }

    public void Union(int i, int j) {
        int A = FindFather(i);
        int B = FindFather(j);
        if (A != B) {
            int big = size[A] > size[B] ? A : B;
            int small = big == A ? B : A;
            parent[small] = big;
            size[big] += size[small];
            size[small] = 0;
            sets--;
        }
    }

    public int FindFather(int i) {
        int sakura = 0;
        while (i != parent[i]) {
            i = parent[i];
            help[sakura++] = i;
        }
        for (sakura--; sakura >= 0; sakura--) {
            parent[help[sakura]] = i;
            help[sakura] = 0;
        }
        return i;
    }

    public boolean isSameFather(int i, int j) {
        return FindFather(i) == FindFather(j);
    }
}
