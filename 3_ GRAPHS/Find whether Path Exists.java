class Solution {
    boolean dfs(int i, int j, int n, int m, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || grid[i][j] == -1)
            return false;
        else if (grid[i][j] == 2)
            return true;

        grid[i][j] = 0;

        boolean up = dfs(i - 1, j, n, m, grid);
        boolean down = dfs(i + 1, j, n, m, grid);
        boolean left = dfs(i, j - 1, n, m, grid);
        boolean right = dfs(i, j + 1, n, m, grid);

        return up || down || left || right;
    }

    public boolean is_Possible(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (dfs(i, j, n, m, grid)) // If there's a path, return true
                        return true;
                }
            }
        }
        return false;
    }
}