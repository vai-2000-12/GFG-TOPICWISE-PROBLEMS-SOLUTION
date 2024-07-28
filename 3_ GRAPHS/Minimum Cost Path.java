import java.util.*;
class Pair {
    int x;
    int y;
    int val;
    
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class Solution {
    // Function to return the minimum cost to reach the bottom right cell from the top left cell.
    public int minimumCostPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
      
        int[][] dist = new int[m][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.val));
      
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
      
        pq.add(new Pair(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];
      
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
      
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.x;
            int c = curr.y;
            int dis = curr.val;
         
            for (int i = 0; i < 4; i++) {
                int new_r = r + dx[i]; 
                int new_c = c + dy[i];
                
                if (new_r >= 0 && new_c >= 0 && new_r < m && new_c < n) {
                    if (dist[new_r][new_c] > dist[r][c] + grid[new_r][new_c]) {
                        dist[new_r][new_c] = dist[r][c] + grid[new_r][new_c];
                        pq.add(new Pair(new_r, new_c, dist[new_r][new_c]));
                    }
                }
            }
        } 
      
        return dist[m-1][n-1];
    }
}
