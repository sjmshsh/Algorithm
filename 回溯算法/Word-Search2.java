class Solution {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        char[] wordarr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, wordarr, visited, i, j, 0) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, boolean[][] visited, int i, int j, int k) {
        if (board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited[i][j] = true; // 代表我们已经访问过了
        for (int[] dir : directions) {
            int newi = i + dir[0];
            int newj = j + dir[1];
            if (!(newi < 0 || newi >= board.length || newj < 0 || newj >= board[0].length)) {
                if (!visited[newi][newj]) {
                    if (dfs(board, word, visited, newi, newj, k + 1)) {
                        return true;
                    }
                }
            }
        }
        visited[i][j] = false;
        return false;
    }
}







