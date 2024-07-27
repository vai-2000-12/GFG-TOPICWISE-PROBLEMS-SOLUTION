import java.util.*;

class Solution {
    int countDistinctIslands(int[][] grid) {
          int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    dfs(i, j, grid, i, j, list);
                    set.add(list.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int x, int y, int[][] grid, int row, int col, List<Integer> l) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Boundary condition:-
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return;
        }
        
        grid[x][y] = 0;
        l.add(x - row);
        l.add(y - col);
        
        dfs(x + 1, y, grid, row, col, l);
        dfs(x, y + 1, grid, row, col, l);
        dfs(x - 1, y, grid, row, col, l);
        dfs(x, y - 1, grid, row, col, l);
    }
}
