class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            // 如果是 = 号的话，那么就先把 = 号加入并查集
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        // 然后遍历不等式
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int i = str.charAt(0) - 'a';
                int j = str.charAt(3) - 'a';
                if (isSameFather(parent, i, j) == true) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int i, int j) {
        parent[find(parent, i)] = find(parent, j);
    }

    public int find (int[] parent, int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    public boolean isSameFather(int[] parent, int i, int j) {
        return find(parent, i) == find(parent, j);
    }
}
