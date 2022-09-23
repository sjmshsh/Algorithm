class Solution {
    boolean[][] rows = new boolean[9][9];
    boolean[][] cols = new boolean[9][9];
    boolean[][][] sq = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    rows[i][num] = cols[j][num] = sq[i / 3][j / 3][num] = true;
                }
            }
        }
        solveSudokuDFS(board, 0, 0);
    }

    // x表示行
    // y表示列
    public boolean solveSudokuDFS(char[][] board, int x, int y) {
        if (y == 9) {
            return solveSudokuDFS(board, x + 1, 0);
        } 
        if (x == 9) {
            return true;
        }
        if (board[x][y] != '.') {
            return solveSudokuDFS(board, x, y + 1); 
        }
        // 把所有的数字全部进行暴搜一遍
        for (int i = 0; i < 9; i++) {
                char ch = (char) (i + '1');
            if (!rows[x][i] && !cols[y][i] && !sq[x / 3][y / 3][i]) { //如果这三者同时没有的话
                board[x][y] = ch;
                rows[x][i] = cols[y][i] = sq[x / 3][y / 3][i] = true;
                if (solveSudokuDFS(board, x, y + 1)) {
                    break;
                } else {
                    rows[x][i] = cols[y][i] = sq[x / 3][y / 3][i] = false;
                    board[x][y] = '.';
                }
            }
        }
        return board[x][y] != '.';
    }
}
