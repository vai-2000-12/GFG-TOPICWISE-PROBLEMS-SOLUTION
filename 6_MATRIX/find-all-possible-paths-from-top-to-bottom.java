import java.util.ArrayList;

class Solution {
    public static ArrayList<ArrayList<Integer>> findAllPossiblePaths(int n,int m, int[][] grid) {
     ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        dfs(0, 0, n, m, grid, list, res);
        return res;
    }
    
    public static void dfs(int x, int y, int n, int m, int[][] grid, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res) {
        // Add the current cell to the path
        list.add(grid[x][y]);
        
        // Base condition: if you've reached the bottom-right corner
        if (x == n - 1 && y == m - 1) {
            res.add(new ArrayList<>(list));
        } else {
            // Move down
            if (x + 1 < n) {
                dfs(x + 1, y, n, m, grid, list, res);
            }
            // Move right
            if (y + 1 < m) {
                dfs(x, y + 1, n, m, grid, list, res);
            }
        }
        
        list.remove(list.size() - 1);
    }
}

        
