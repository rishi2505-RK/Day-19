class Solution {
    private int m, n;
    private boolean[][] vis;
    private char[][] grid;
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && dfs(i, j, -1, -1, grid[i][j])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int px, int py, char ch) {
        vis[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                continue;
            if (grid[nx][ny] != ch)
                continue;
            if (nx == px && ny == py)
                continue;

            if (vis[nx][ny])
                return true;

            if (dfs(nx, ny, x, y, ch))
                return true;
        }

        return false;
    }
}