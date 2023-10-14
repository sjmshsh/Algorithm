class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid[0].size(); j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    void bfs(vector<vector<char>>& grid, int i, int j) {
        queue<vector<int>> q;
        q.push({i, j});
        while (!q.empty()) {
            vector<int> cur = q.front();
            q.pop();
            i = cur[0];
            j = cur[1];
            if (i >= 0 && i < grid.size() && j >= 0 && j < grid[0].size() && grid[i][j] == '1') {
                grid[i][j] = '0';
                q.push({i + 1, j});
                q.push({i - 1, j});
                q.push({i, j + 1});
                q.push({i, j - 1});
            }
        }
    }
};
