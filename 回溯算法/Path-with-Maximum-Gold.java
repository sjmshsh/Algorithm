class Solution {

    private int[][] g;
    private boolean[][] vis;
    int N = 0;
    int M = 0;
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public int getMaximumGold(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        g = grid;
        vis = new boolean[N][M];
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] != 0) {
                    vis[i][j] = true;
                    ans = Math.max(ans, dfs(i , j));
                    vis[i][j] = false;
                }
            }
        }
        return ans;
    }

    public int dfs (int x, int y) {
        int ans = g[x][y];
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }
            if (vis[nx][ny] == true) {
                continue;
            }
            if (g[nx][ny] == 0) {
                continue;
            }
            vis[nx][ny] = true;
            ans = Math.max(ans, dfs(nx, ny) + g[x][y]);
            vis[nx][ny] = false;
        }
        return ans;
    }
}
