import java.util.*;
// User function Template for Java
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
      int m = grid.length;
      int n = grid[0].length;
      
      if(grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0){
          return -1;
      }
      
      grid[source[0]][source[1]] = 0;
      Queue<int[]> q = new LinkedList<>();
      q.add(new int[]{source[0], source[1], 0});  
      
      int [] dx = {-1,  0 , 0, 1};
      int [] dy = {0  , -1 , 1, 0};
      
      while(!q.isEmpty()){
           int [] cell = q.poll();
            int r = cell[0];
            int c = cell[1];
            int dis = cell[2];
            
            if(r == destination[0] && c == destination[1]){
                return dis;
            }
            
            for( int i = 0 ; i < 4 ; i++){
                int nr = r + dx[i];
                int nc = c + dy[i];
              if( nr >= 0  && nc >= 0 && nr < m && nc < n && grid[nr][nc] == 1){
                 q.add(new int[]{nr , nc , dis + 1});
                 grid[nr][nc] = 0;
               } 
            }
      }
     
      return -1;
    }
}