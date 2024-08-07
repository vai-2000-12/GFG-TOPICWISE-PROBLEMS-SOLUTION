import java.util.*;

class Solution{
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        int time = 0;
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j, 0});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
         int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int min = curr[2];
            
            // Update the maximum time taken
            time = min;
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    freshOranges--;
                    q.add(new int[]{nr, nc, min + 1});
                }
            }
        }
        
        // If there are still fresh oranges left, return -1
        if (freshOranges > 0) {
            return -1;
        } else {
            return time;
        }
      }
    }
    