class Solution {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        // 这个数组用来存放当前节点下标的关键节点下标
        int[] parent = new int[cities];
        // 一开始下标里面的关键节点都是它自己
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    public void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }

    public int find(int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }
}

