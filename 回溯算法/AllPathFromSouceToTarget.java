class Solution {
    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private int N = 0;
    private int M = 0;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        N = graph.length;
        path.add(0);
        allPathsSourceTargetCore(graph, 0);
        return list;
    }

    // x表示我的节点的编号，也就是说x代表的是我目前的遍历遍历到了哪一个节点了
    public void allPathsSourceTargetCore(int[][] graph, int x) {
        if (N - 1 == x) {
            // 如果我当前到达的节点的编号是最后一个的话
            list.add(new ArrayList(path)); // 注意这里必须要new一个ArrayList，否则的话，这个引用还是指向我的path的，我的path回溯的时候就无了
            return;
        }
        for (int i = 0; i < graph[x].length; i++) {
            path.add(graph[x][i]);
            allPathsSourceTargetCore(graph, graph[x][i]);
            path.remove(path.size() - 1);
        }
    }
}
