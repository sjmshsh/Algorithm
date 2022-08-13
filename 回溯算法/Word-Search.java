class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wordarr = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, wordarr, i, j, 0) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    // k代表的是字符串的索引位置
    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k+ 1);
        board[i][j] = word[k];
        return res;
    }
}
