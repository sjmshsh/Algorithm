package Graph;

import UnionFindSet.UnionF;
import UnionFindSet.UnionF1;

import java.util.*;

/**
 * @Author 写你的名字
 * @Date 2022/7/15 12:19 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

/*
* 邻接矩阵版本
* */
public class Graph<V> {
    // 顶点集合, 通过下标可以找到一个点
    private List<V> vertexs = new ArrayList<>();
    // 邻接矩阵
    private int[][] matrix;
    // 顶点映射下标, 通过点可以找到一个下标
    private Map<V, Integer> indexMap = new HashMap<>();

    // 用来表示是有向图还是无向图
    boolean Direction = true;

    // 图的创建
    // 1.IO输入  --不方便测试，oj中更适合
    // 2.样例写到文件
    // 3.手动添加边
    public Graph(V[] a, boolean direction) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            vertexs.add(a[i]);
            indexMap.put(a[i], i);
        }
        matrix = new int[n][n];
        // 把邻接矩阵初始化为整数最大值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        Direction = direction;
    }

    int GetVertexIndex(V src) {
        boolean flg = indexMap.containsKey(src);
        if (flg == true) {
            return indexMap.get(src);
        } else {
            return -1;
        }
    }

    // src表示从哪里来，dst表示到哪里去，w表示边权
    public void AddEdge(V src, V dst, int w) {
        // 得到源头和目标的下标
        int srci = GetVertexIndex(src);
        int dsti = GetVertexIndex(dst);
        matrix[srci][dsti] = w;
        // 无向图
        if (Direction == false) {
            matrix[dsti][srci] = w;
        } else {
            matrix[dsti][srci] = w;
            matrix[srci][dsti] = w;
        }
    }

    public void Print() {
        // 顶点
        for (int i = 0; i < vertexs.size(); i++) {
            System.out.println("[" + i + "] -> " + vertexs.get(i));
        }
        System.out.println();
        for (int i = 0; i <= matrix.length; i++) {
            if (i != 0) {
                System.out.print(i - 1 + "   ");
            } else {
                System.out.print("    ");
            }
        }
        System.out.println();
        // 矩阵
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    System.out.print("*   ");
                } else {
                    System.out.print(matrix[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }


    public void BFS1(V src) {
        // 得到这个节点的下标
        int srci = GetVertexIndex(src);
        Queue<Integer> q = new LinkedList<>();
        // 我们要从src开始遍历，因此我们把src加入队列
        q.add(srci);
        // 定义标记数组, 这里直接使用数组来代替
        boolean[] visited = new boolean[vertexs.size()];
        // 对src这里的下标进行标记
        visited[srci] = true;
        while (!q.isEmpty()) {
            int front = q.poll();
            System.out.println(front + " " + vertexs.get(front));
            // 把front顶点的邻接顶点放进去
            for (int i = 0; i < vertexs.size(); i++) {
                if (matrix[front][i] != Integer.MAX_VALUE) {
                    if (visited[i] == false) {
                        q.add(i);
                        visited[i] = true;
                    }
                }
            }
        }
    }

    // 改进BFS1函数方法
    public void BFS2(V src) {
        int srci = GetVertexIndex(src);
        // 队列和标记数组
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[vertexs.size()];

        q.add(srci);
        visited[srci] = true;
        int levelSize = 1;

        while (!q.isEmpty()) {
            for (int i = 0; i < levelSize; i++) {
                int front = q.poll();
                System.out.println(front + " " + vertexs.get(front));
                // 把 front 顶点的邻接顶点入队列
                for (int j = 0; j < vertexs.size(); j++) {
                    if (matrix[front][j] != Integer.MAX_VALUE) {
                        if (visited[j] == false) {
                            q.add(j);
                            visited[j] = true;
                        }
                    }
                }
            }
            levelSize = q.size();
        }
    }

    public void DFS(V src) {
        int srci = GetVertexIndex(src);
        boolean[] visited = new boolean[vertexs.size()];
        _DFS(srci, visited);
    }

    public void _DFS(int srci, boolean[] visited) {
        System.out.println(srci + " " + vertexs.get(srci));
        visited[srci] = true;

        // 找一个srci相邻的没有访问过的点，去往深度遍历
        for (int i = 0; i < vertexs.size(); i++) {
            if (matrix[srci][i] != Integer.MAX_VALUE && visited[i]) {
                _DFS(i, visited);
            }
        }
    }


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
            return -1; // 无环
        }
    }

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

    public static void main(String[] args) {
        Character[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        Graph<Character> g = new Graph<Character>(str, true);
        g.AddEdge('a', 'b', 4);
        g.AddEdge('a', 'h', 8);
        //g.AddEdge('a', 'h', 9);
        g.AddEdge('b', 'c', 8);
        g.AddEdge('b', 'h', 11);
        g.AddEdge('c', 'i', 2);
        g.AddEdge('c', 'f', 4);
        g.AddEdge('c', 'd', 7);
        g.AddEdge('d', 'f', 14);
        g.AddEdge('d', 'e', 9);
        g.AddEdge('e', 'f', 10);
        g.AddEdge('f', 'g', 2);
        g.AddEdge('g', 'h', 1);
        g.AddEdge('g', 'i', 6);
        g.AddEdge('h', 'i', 7);
        System.out.println(g.Kruskal());
    }
}

