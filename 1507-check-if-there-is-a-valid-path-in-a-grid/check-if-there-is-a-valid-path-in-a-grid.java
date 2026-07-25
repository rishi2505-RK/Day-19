import java.util.*;

class Solution {

    int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};

    int[][] typeDirs = {
        {},
        {0,1},  
        {2,3},   
        {0,3},  
        {1,3},   
        {0,2},   
        {1,2}   
    };

    int[] opposite = {1,0,3,2};

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == m - 1 && y == n - 1)
                return true;

            for (int d : typeDirs[grid[x][y]]) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || vis[nx][ny])
                    continue;

                boolean ok = false;
                for (int nd : typeDirs[grid[nx][ny]]) {
                    if (nd == opposite[d]) {
                        ok = true;
                        break;
                    }
                }

                if (ok) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}